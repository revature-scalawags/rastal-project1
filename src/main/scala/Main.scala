package me.rastal.project1

import java.lang
import java.util.StringTokenizer

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.{IntWritable, Text}
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.mapreduce.{Job, Mapper, Reducer}

import scala.jdk.CollectionConverters._

object Main extends App {
  processArgs(args)
  
  val configuration = new Configuration
  val job = Job.getInstance(configuration, "revision data")
  job.setJarByClass(this.getClass)
  args(2) match {
    case "pages" => job.setMapperClass(classOf[PageRevisionMapper])
    case "users" => job.setMapperClass(classOf[UserRevisionMapper])
  }
  job.setCombinerClass(classOf[RevisionReducer])
  job.setReducerClass(classOf[RevisionReducer])
  job.setOutputKeyClass(classOf[Text])
  job.setOutputValueClass(classOf[IntWritable])
  FileInputFormat.addInputPath(job, new Path(args(0)))
  FileOutputFormat.setOutputPath(job, new Path(args(1)))
  System.exit(if(job.waitForCompletion(true)) 0 else 1)

  def processArgs(args: Array[String], test: Boolean = false): Unit = {
    if (args.length != 3 || !(args(2) == "users" || args(2) == "pages")) {
      if (!test) {
        println("Usage: Main [input dir] [output dir] ['pages'/'users']")
        System.exit(-1)
      } else {
        // TODO actually fill out stuff that could test this
      }
    }
  }
}

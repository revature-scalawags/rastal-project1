package me.rastal.project1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.{IntWritable, MapWritable, Text}
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat

import scala.jdk.CollectionConverters._

object Main extends App {
  processArgs(args)

  val configuration = new Configuration
  val job = Job.getInstance(configuration, "revision data")
  job.setJarByClass(this.getClass)
  args(2) match {
    case "pages" => job.setMapperClass(classOf[PageRevisionMapper])
    case "users" => job.setMapperClass(classOf[UserRevisionMapper])
    case "usersByPage" => job.setMapperClass(classOf[UserRevisionByPageMapper])
  }
  args(2) match {
    case "pages" | "users" =>
      job.setCombinerClass(classOf[RevisionReducer])
      job.setReducerClass(classOf[RevisionReducer])
      job.setOutputValueClass(classOf[IntWritable])
    case "usersByPage" => 
      job.setCombinerClass(classOf[UserRevisionByPageReducer])
      job.setReducerClass(classOf[UserRevisionByPageReducer])
      job.setOutputValueClass(classOf[MapWritable])
  }
  job.setOutputKeyClass(classOf[Text])
  FileInputFormat.addInputPath(job, new Path(args(0)))
  FileOutputFormat.setOutputPath(job, new Path(args(1)))
  System.exit(if(job.waitForCompletion(true)) 0 else 1)

  def processArgs(args: Array[String], test: Boolean = false): Unit = {
    if (args.length != 3 || !(args(2) == "users" || args(2) == "pages")) {
      if (!test) {
        println("Usage: Main [input dir] [output dir] [job type]\n" +
                "Job types: 'pages' 'users' 'usersByPage'")
        System.exit(-1)
      } else {
        // TODO actually fill out stuff that could test this
      }
    }
  }
}

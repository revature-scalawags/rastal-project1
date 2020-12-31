package me.rastal.project1

import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.io.{IntWritable, Text}

class PageRevisionMapper extends Mapper[Object, Text, Text, IntWritable] {
  override def map(key: Object, 
                   value: Text, 
                   context: Mapper[Object, Text, Text, IntWritable]#Context): Unit = {
    val line = value.toString
    val fields = line.split('\t')
    if (fields(1) == "revision") {
      context.write(new Text(fields(25)), new IntWritable(1))
    }
  }
}
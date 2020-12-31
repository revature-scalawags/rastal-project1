package me.rastal.project1

import org.apache.hadoop.mapreduce.Reducer
import org.apache.hadoop.io.{IntWritable, Text}
import scala.jdk.CollectionConverters._

class RevisionReducer extends Reducer[Text, IntWritable, Text, IntWritable] {
  override def reduce(key: Text, 
                      values: java.lang.Iterable[IntWritable], 
                      context: Reducer[Text, IntWritable, Text, IntWritable]#Context): Unit = {
    val sum = values.asScala.foldLeft(0)(_ + _.get)
    context.write(key, new IntWritable(sum))
  }
}

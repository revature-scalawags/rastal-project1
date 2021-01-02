package me.rastal.project1

import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.io.{IntWritable, MapWritable, Text}

class UserRevisionByPageMapper extends Mapper[Object, Text, Text, Text] {
  override def map(key: Object,
                   value: Text,
                   context: Mapper[Object, Text, Text, Text]#Context): Unit = {
    val line = value.toString
    val fields = line.split('\t')
    val event = fields(1)
    val title = fields(25)
    if (event == "revision" && title.length > 0) {
      val user = new Text(fields(7))
      context.write(new Text(title), user)
    }
  }
}

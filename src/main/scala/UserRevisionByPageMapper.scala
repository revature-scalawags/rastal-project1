package me.rastal.project1

import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.io.{IntWritable, MapWritable, Text}

class UserRevisionByPageMapper extends Mapper[Object, Text, Text, MapWritable] {
  override def map(key: Object,
                   value: Text,
                   context: Mapper[Object, Text, Text, MapWritable]#Context): Unit = {
    val line = value.toString
    val fields = line.split('\t')
    val event = fields(1)
    val title = fields(25)
    if (event == "revision" && title.length > 0) {
      val map = new MapWritable()
      val user = new Text(fields(7))
      map.put(user, new IntWritable(1))
      context.write(new Text(title), map)
    }
  }
}

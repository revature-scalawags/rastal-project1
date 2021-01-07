package me.rastal.project1

import org.apache.hadoop.mapreduce.Reducer
import org.apache.hadoop.io.{IntWritable, MapWritable, Text}
import scala.collection.immutable.ListMap
import scala.jdk.CollectionConverters._

class UserRevisionByPageReducer extends Reducer[Text, Text, Text, MapWritable] {
  override def reduce(page: Text, 
                      users: java.lang.Iterable[Text], 
                      context: Reducer[Text, Text, Text, MapWritable]#Context): Unit = {
    val map = new MapWritable()
    val counts = users.asScala.groupMapReduce(identity)(_ => 1)(_ + _)
    val sorted = ListMap(counts.toSeq.sortWith(_._2 > _._2):_*)
    sorted.foreach(x => map.put(x._1, new IntWritable(x._2)))
    context.write(page, map)
  }
}

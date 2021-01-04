## Features

- At least one Hadoop node on my local machine (easy)
  - Got this up and running pretty painlessly as a pseudo-distributed node. Because it's not just hosted directly on my local filesystem, I have to use the HDFS commands to get data into and out of it.
- Download Wikipedia 2020 edit histories into hadoop cluster (easy)
  - took a little longer to figure out than I expected, but now that I know how it works, it's fairly easy
- Command line interface to run queries (medium)
  - this was really straightforward for MapReduce jobs
- MapReduce job for counting times profonity was removed from articles (hard)
  - the data ended up just being page history metadata, and didn't include any content that was revised (no diffs)
- MapReduce jobs for counting most revised pages and most active users (easy)
  - this ended up being a little bit harder than expected, just because I had to wrap my head around the inputs and outputs of Mappers and Reducers
- Jar file for running MapReduce program on HDFS (easy)
  - once I understood how to actually run this on HDFS (with `hadoop jar`), this was pretty easy
- MapReduce job for finding most active users on each page (medium)
  - Once I got my head around how mapping and reducing worked and saw that MapWritable was a type built into Hadoop, this ended up being easier to implement than I expected
- Hive queries for returning MapReduced data sorted in descending order by counts (medium)
  - *to be determined*
- Multi-node Hadoop cluster using AWS (medium)
  - ended up not having time to even attempt implementing this; MapReduce took more time to learn / implement than I expected
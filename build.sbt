name := "rastal-project1"

version := "0.1"

scalaVersion := "2.13.4"

idePackagePrefix := Some("me.rastal.project1")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
libraryDependencies += "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "3.2.1"
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "3.2.1"
libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.2"

assemblyMergeStrategy in assembly := {   
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard   
  case x => MergeStrategy.first 
}
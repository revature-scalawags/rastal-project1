name := "rastal-project1"

version := "0.1"

scalaVersion := "2.13.4"

idePackagePrefix := Some("me.rastal.project1")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
libraryDependencies += "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "3.3.0"
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "3.3.0"
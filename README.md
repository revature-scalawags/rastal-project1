# Wikipedia Revision History Analysis

## Project Description

Runs MapReduce algorithms determining the number of times individual Wikipedia pages were revised or the number of times individual users performed revisions in a given revision history dataset.

## Technologies Used

* Scala - version 2.13.4
* sbt - version 1.4.6
* Apache Hadoop - version 3.2.1
* sbt assembly - version 0.15.0

## Features

* Read English Wikipedia revision history data from an HDFS cluster.
* Return a dataset of revised pages paired with the number of times they were revised.
* Return a dataset of users paired with the number of times that user revised a page.

To-do list:
* Return a dataset containing individual pages paired with a map of the users who made the revisions and the number of revisions the user performed.
* Order the "users by page" dataset in descending order by most page revisions, then order the users in each page by most revisions.

## Getting Started

### Download

To download this project, navigate to the directory you'd like to download the project to:

`cd folder/to/clone-into/`

Then use:

`git clone https://github.com/revature-scalawags/rastal-project1.git`

to download the project as a whole into your working directory.

Also, download at least one of the English Wikipedia Revision history datasets [here](https://dumps.wikimedia.org/other/mediawiki_history/2020-12/enwiki/). 

### Requirements

Running this project requires the Java JDK (8 or 11) and Scala with sbt, as well as a psuedo-distributed Hadoop cluster on your local machine.

#### Java and Scala

To get started with Java and Scala, follow the instructions [here](https://scala-lang.org/download/) and choose the "Download sbt" link instead of "Download IntelliJ."

#### Hadoop

For Hadoop, follow the instructions [here](https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html) for downloading and installing Hadoop, followed by those for setting up a "Pseudo-Distributed Operation."

Start a local hadoop cluster by following steps 1 - 5 of the "Execution" instructions [here](https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html#Execution), copying the dataset(s) you downloaded in the previous step to the HDFS in the process.

## Usage

In a terminal, navigate to the directory containing this project. Once there, run the program with 

`sbt "run [input dir] [output dir] [job type]"`

Replace `[input dir]` with the HDFS location of the dataset you copied into Hadoop.

Replace `[output dir]` with the HDFS location you'd like to output the MapReduce results to.

Replace `[job type]` with either `users` to count the number of revisions by user or `pages` to count the number of revisions by page.

The output data will not be sorted, so you'll need to run it through a Hive query or other program to extract meaningful information out of the data.

## License

This project is licensed under the Apache License, Version 2.0 (the "License");
you may not use this project except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

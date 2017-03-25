# MaxTemperature

This *mapreduce* procedure mines weather data from the [National Climatic Data Center](http://www.ncdc.noaa.gov/). These data have been collected every hour by Weather sensors at many locations across the globe. The data for years 1901 & 1902 is provided in this repository. The data is stored using a line-oriented ASCII format, in which each line is a record. The procedure determine the maximal temperature for each year.  
It is implemented as a **Hadoop Mapreduce** job. This application and the associated *Java* source code come from the chapter 2 of the excelent book *Hadoop the Definitive Guide, 4th ed* from *Tom White*. The source code was downloaded from the book's [*Github* repository](https://github.com/tomwhite/hadoop-book/tree/master/ch02-mr-intro/src/main/java) (visit the book's [website](http://hadoopbook.com/code.html)).

The purpose of my repository is more to give an exhaustive description of the process of running this *mapreduce* program with [Apache Hadoop](http://hadoop.apache.org/) than expose the algorithm and the source code.

Some basic information about my configuration:

|   |   |
|---|---|
| **OS**      | Linux 64 bits, Fedora 25 |
| **Hadoop**  | version 2.7.3            |
| **openjdk** | version 1.8.0_121        |


## Content of the repository

| directory  | Content  |
|------------|----------|
| `./data`   | Raw text files `1901` and `1902` with weather data from the NCDC |
| `./src`    | Java source code                                                 |


## Compile the Java source code
The Java source code is composed of the 3 `.java` files:  
`./src/MaxTemperature.java`    
`./src/MaxTemperatureMapper.java`  
`./src/MaxTemperatureReducer.java`  

It can be compiled with GNU `make`. The `Makefile` needs the environment variable `$HADOOP_HOME` to be defined. Run GNU `make` in the `./src ` directory:  
`$> make`  
or  
`$> make -f Makefile`  
A Java archive (.jar) `MaxTemperature.jar` is then created in the `./src` directory.

## Run the Mapreduce job on Hadoop

Here are the steps I follow to carry out the whole task.

### Formatting of the Hadoop distributed file system (HDFS)
Use the following command:  
`$> hdfs namenode -format`
This must be done before starting the HDFS. What was not obvious for me at once, is that after having stopped Hadoop with `stop-dfs.sh` you'll have to perform this task each time you restart it. If you do not, you will get a *connection error*.

### Start the HDFS
Start Hadoop with the following command:
`$> start-dfs.sh`

### Create directoris in the HDFS
The root directory of the HDFS is initially empty. If you do a listing of that directory you will get nothing:
`$> hadoop fs -ls /`
I will create a directory `/user/flaudanum` in the HDFS for storing the input and output files from my Mapreduce job.  
`$> hadoop fs -mkdir /user`  
`$> hadoop fs -mkdir /user/flaudanum`  
Eventually create a directory for for storing input data:  
`$> hadoop fs -mkdir /user/flaudanum/input`  

### Transfer the data files to the HDFS
Transfer the data with `-put`:  
`$> hadoop fs -put ./data/190* /user/flaudanum/input`  
Check the copied files on the HDFS:  
`$> hadoop fs -ls /user/flaudanum/input`

### Run the Mapreduce job
Now that the data is on the HDFS, it is time to run the Mapreduce job with the `hadoop jar` command:
`$> hadoop jar ./src/MaxTemperature.jar MaxTemperature /user/flaudanum/input /user/flaudanum/output`
The shell output of the command is available [here](hadoop.jar.md)

**Beware** If you run hadoop in standalone (local) mode like me, you shall check in the `mapred-site.xml` in hadoop install directory that the value associated to the property `mapreduce.framework.name` is set to `local` (my default value was `yarn`). Here is the content of my file `mapred-site.xml`:  
```XML
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<!--
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License. See accompanying LICENSE file.
-->

<!-- Put site-specific property overrides in this file. -->

<configuration>
<!--    <property>-->
<!--        <name>mapreduce.framework.name</name>-->
<!--        <value>yarn</value>-->
<!--    </property>-->
    <property>
        <name>mapreduce.framework.name</name>
        <value>local</value>
    </property>
</configuration>
```

### Get the result file from HDFS to the local file system
The data produced by the job is available in the directory `/user/flaudanum/output` (that was specified in the `hadoop jar` command) of the HDFS. It contains 2 files:  
```
$> hadoop fs -ls /user/flaudanum/output/
Found 2 items
-rw-r--r--   1 flaudanum supergroup          0 2017-03-26 00:27 /user/flaudanum/output/_SUCCESS
-rw-r--r--   1 flaudanum supergroup         18 2017-03-26 00:27 /user/flaudanum/output/part-r-00000
```
File `_SUCCESS` is empty and just stands as a flag for indicating that the job was successfull. The mapreduced data are in the file `part-r-00000`.
The content of this file can be streamed to the standard output:  
`$> hadoop fs -cat /user/flaudanum/output/part-r-00000`  
The data file can also be transfered to the directory `./hadoop_res` in the local file system:  
`$> hadoop fs -get /user/flaudanum/output/ ./hadoop_res`

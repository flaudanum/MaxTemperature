# MaxTemperature

This *mapreduce* procedure mines weather data from the [National Climatic Data Center](http://www.ncdc.noaa.gov/). These data have been collected every hour by Weather sensors at many locations across the globe. The data for years 1901 & 1902 is provided in this repository. The data is stored using a line-oriented ASCII format, in which each line is a record. The procedure determine the maximal temperature for each year.  
It is implemented as a **Hadoop Mapreduce** job. This application and the associated *Java* source code come from the chapter 2 of the excelent book *Hadoop the Definitive Guide, 4th ed* from *Tom White*. The source code was downloaded from the book's [*Github* repository](https://github.com/tomwhite/hadoop-book/tree/master/ch02-mr-intro/src/main/java) (visit the book's [website](http://hadoopbook.com/code.html)).

The purpose of my repository is more to give an exhaustive description of the process of running this *mapreduce* program with [Apache Hadoop](http://hadoop.apache.org/) than expose the algorithm and the source code.

Besides, I also translated the Java code in Scala code.

Some basic information about my configuration:

|   |   |
|---|---|
| **OS**      | Linux 64 bits, Fedora 25 |
| **Hadoop**  | version 2.7.3            |
| **openjdk** | version 1.8.0_121        |
| **Maven**   | version 3.3.9            |

## Content of the repository
The directory structure is compatible with **Apache Maven** standard ([more details](https://maven.apache.org/guides/getting-started/)).

| directory           | Content  |
|---------------------|----------|
| `./data`            | Raw text files `1901` and `1902` with weather data from the NCDC |
| `./src/main/java`   | Java source code and Makefile                                    |
| `./pom.xml`         | Project Object Model XML file for Maven                          |

## Compile the Java source code and create a JAR
The Java source code is composed of the 3 `.java` files:  
`./java/MaxTemperature.java`    
`./java/MaxTemperatureMapper.java`  
`./java/MaxTemperatureReducer.java`  

It can be compiled with GNU `make`. The `Makefile` needs the environment variable `$HADOOP_HOME` to be defined.
Run GNU `make` in the `./src/main/java` directory where the .java source files are:  
`$> make`  
or  
`$> make -f Makefile`  
A Java archive (JAR) `MaxTemperature.jar` is then created in the `./src/main/java` directory.

## Use Apache Maven
In the root directory `./`, there is the `pom.xml` for the **Maven** project to be built. This `pom.xml` exhibits a
basic structure for building a *MapReduce* job for *Hadoop*. Comments in the file give short descriptions of the
meaning of the various XML elements.

From the root directory, run:  
`$> mvn clean` for cleaning a pre-existing build  
`$> mvn compile` for compiling the .java source files into .class files  
`$> mvn package` for creating the Java archive (JAR)


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
Now that the data is on the HDFS, it is time to run the Mapreduce job with the `hadoop jar` command.
If you built the JAR with GNU make then the JAR should be in `./src/main/java`. Change to that directory and run:  
`$> hadoop jar ./java/MaxTemperature.jar MaxTemperature /user/flaudanum/input /user/flaudanum/output`  
If you built the JAR with Maven then it should be directly in the root directory.

The shell output of the command is available [here](hadoop.jar.md)  

**Beware** If you run hadoop in standalone (local) mode like me, you shall check in the `mapred-site.xml` in hadoop
install directory that the value associated to the property `mapreduce.framework.name` is set to `local` (my default
value was `yarn`). Here is the content of my file `mapred-site.xml`:  
```XML
<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>

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

**Remark** Before running again the MapReduce job, remove the output directory, otherwise Hadoop will send an error:  
`$> hadoop fs -rm -r /user/flaudanum/output`

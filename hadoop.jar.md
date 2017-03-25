Here is the ouput I got in my shell after running the job.
```
17/03/26 00:27:51 INFO Configuration.deprecation: session.id is deprecated. Instead, use dfs.metrics.session-id
17/03/26 00:27:51 INFO jvm.JvmMetrics: Initializing JVM Metrics with processName=JobTracker, sessionId=
17/03/26 00:27:51 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/03/26 00:27:51 INFO input.FileInputFormat: Total input paths to process : 2
17/03/26 00:27:51 INFO mapreduce.JobSubmitter: number of splits:2
17/03/26 00:27:52 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local1240936221_0001
17/03/26 00:27:52 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
17/03/26 00:27:52 INFO mapreduce.Job: Running job: job_local1240936221_0001
17/03/26 00:27:52 INFO mapred.LocalJobRunner: OutputCommitter set in config null
17/03/26 00:27:52 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/03/26 00:27:52 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
17/03/26 00:27:52 INFO mapred.LocalJobRunner: Waiting for map tasks
17/03/26 00:27:52 INFO mapred.LocalJobRunner: Starting task: attempt_local1240936221_0001_m_000000_0
17/03/26 00:27:52 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/03/26 00:27:52 INFO mapred.Task:  Using ResourceCalculatorProcessTree : [ ]
17/03/26 00:27:52 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/flaudanum/input/1902:0+888978
17/03/26 00:27:52 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
17/03/26 00:27:52 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
17/03/26 00:27:52 INFO mapred.MapTask: soft limit at 83886080
17/03/26 00:27:52 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
17/03/26 00:27:52 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
17/03/26 00:27:52 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
17/03/26 00:27:52 INFO mapred.LocalJobRunner:
17/03/26 00:27:52 INFO mapred.MapTask: Starting flush of map output
17/03/26 00:27:52 INFO mapred.MapTask: Spilling map output
17/03/26 00:27:52 INFO mapred.MapTask: bufstart = 0; bufend = 59085; bufvoid = 104857600
17/03/26 00:27:52 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26188140(104752560); length = 26257/6553600
17/03/26 00:27:52 INFO mapred.MapTask: Finished spill 0
17/03/26 00:27:52 INFO mapred.Task: Task:attempt_local1240936221_0001_m_000000_0 is done. And is in the process of committing
17/03/26 00:27:52 INFO mapred.LocalJobRunner: map
17/03/26 00:27:52 INFO mapred.Task: Task 'attempt_local1240936221_0001_m_000000_0' done.
17/03/26 00:27:52 INFO mapred.LocalJobRunner: Finishing task: attempt_local1240936221_0001_m_000000_0
17/03/26 00:27:52 INFO mapred.LocalJobRunner: Starting task: attempt_local1240936221_0001_m_000001_0
17/03/26 00:27:52 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/03/26 00:27:52 INFO mapred.Task:  Using ResourceCalculatorProcessTree : [ ]
17/03/26 00:27:52 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/flaudanum/input/1901:0+888190
17/03/26 00:27:52 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
17/03/26 00:27:52 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
17/03/26 00:27:52 INFO mapred.MapTask: soft limit at 83886080
17/03/26 00:27:52 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
17/03/26 00:27:52 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
17/03/26 00:27:52 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
17/03/26 00:27:52 INFO mapred.LocalJobRunner:
17/03/26 00:27:52 INFO mapred.MapTask: Starting flush of map output
17/03/26 00:27:52 INFO mapred.MapTask: Spilling map output
17/03/26 00:27:52 INFO mapred.MapTask: bufstart = 0; bufend = 59076; bufvoid = 104857600
17/03/26 00:27:52 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26188144(104752576); length = 26253/6553600
17/03/26 00:27:52 INFO mapred.MapTask: Finished spill 0
17/03/26 00:27:52 INFO mapred.Task: Task:attempt_local1240936221_0001_m_000001_0 is done. And is in the process of committing
17/03/26 00:27:52 INFO mapred.LocalJobRunner: map
17/03/26 00:27:52 INFO mapred.Task: Task 'attempt_local1240936221_0001_m_000001_0' done.
17/03/26 00:27:52 INFO mapred.LocalJobRunner: Finishing task: attempt_local1240936221_0001_m_000001_0
17/03/26 00:27:52 INFO mapred.LocalJobRunner: map task executor complete.
17/03/26 00:27:52 INFO mapred.LocalJobRunner: Waiting for reduce tasks
17/03/26 00:27:52 INFO mapred.LocalJobRunner: Starting task: attempt_local1240936221_0001_r_000000_0
17/03/26 00:27:52 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/03/26 00:27:52 INFO mapred.Task:  Using ResourceCalculatorProcessTree : [ ]
17/03/26 00:27:52 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@2eafd039
17/03/26 00:27:52 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=334338464, maxSingleShuffleLimit=83584616, mergeThreshold=220663392, ioSortFactor=10, memToMemMergeOutputsThreshold=10
17/03/26 00:27:52 INFO reduce.EventFetcher: attempt_local1240936221_0001_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
17/03/26 00:27:52 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1240936221_0001_m_000001_0 decomp: 72206 len: 72210 to MEMORY
17/03/26 00:27:52 INFO reduce.InMemoryMapOutput: Read 72206 bytes from map-output for attempt_local1240936221_0001_m_000001_0
17/03/26 00:27:52 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 72206, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->72206
17/03/26 00:27:52 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1240936221_0001_m_000000_0 decomp: 72217 len: 72221 to MEMORY
17/03/26 00:27:52 INFO reduce.InMemoryMapOutput: Read 72217 bytes from map-output for attempt_local1240936221_0001_m_000000_0
17/03/26 00:27:52 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 72217, inMemoryMapOutputs.size() -> 2, commitMemory -> 72206, usedMemory ->144423
17/03/26 00:27:52 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
17/03/26 00:27:52 WARN io.ReadaheadPool: Failed readahead on ifile
EBADF: Bad file descriptor
	at org.apache.hadoop.io.nativeio.NativeIO$POSIX.posix_fadvise(Native Method)
	at org.apache.hadoop.io.nativeio.NativeIO$POSIX.posixFadviseIfPossible(NativeIO.java:267)
	at org.apache.hadoop.io.nativeio.NativeIO$POSIX$CacheManipulator.posixFadviseIfPossible(NativeIO.java:146)
	at org.apache.hadoop.io.ReadaheadPool$ReadaheadRequestImpl.run(ReadaheadPool.java:206)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
17/03/26 00:27:52 INFO mapred.LocalJobRunner: 2 / 2 copied.
17/03/26 00:27:52 INFO reduce.MergeManagerImpl: finalMerge called with 2 in-memory map-outputs and 0 on-disk map-outputs
17/03/26 00:27:52 INFO mapred.Merger: Merging 2 sorted segments
17/03/26 00:27:52 INFO mapred.Merger: Down to the last merge-pass, with 2 segments left of total size: 144409 bytes
17/03/26 00:27:52 INFO reduce.MergeManagerImpl: Merged 2 segments, 144423 bytes to disk to satisfy reduce memory limit
17/03/26 00:27:52 INFO reduce.MergeManagerImpl: Merging 1 files, 144425 bytes from disk
17/03/26 00:27:52 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
17/03/26 00:27:52 INFO mapred.Merger: Merging 1 sorted segments
17/03/26 00:27:52 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 144414 bytes
17/03/26 00:27:52 INFO mapred.LocalJobRunner: 2 / 2 copied.
17/03/26 00:27:52 INFO Configuration.deprecation: mapred.skip.on is deprecated. Instead, use mapreduce.job.skiprecords
17/03/26 00:27:53 INFO mapred.Task: Task:attempt_local1240936221_0001_r_000000_0 is done. And is in the process of committing
17/03/26 00:27:53 INFO mapred.LocalJobRunner: 2 / 2 copied.
17/03/26 00:27:53 INFO mapred.Task: Task attempt_local1240936221_0001_r_000000_0 is allowed to commit now
17/03/26 00:27:53 INFO output.FileOutputCommitter: Saved output of task 'attempt_local1240936221_0001_r_000000_0' to hdfs://localhost:9000/user/flaudanum/output/_temporary/0/task_local1240936221_0001_r_000000
17/03/26 00:27:53 INFO mapred.LocalJobRunner: reduce > reduce
17/03/26 00:27:53 INFO mapred.Task: Task 'attempt_local1240936221_0001_r_000000_0' done.
17/03/26 00:27:53 INFO mapred.LocalJobRunner: Finishing task: attempt_local1240936221_0001_r_000000_0
17/03/26 00:27:53 INFO mapred.LocalJobRunner: reduce task executor complete.
17/03/26 00:27:53 INFO mapreduce.Job: Job job_local1240936221_0001 running in uber mode : false
17/03/26 00:27:53 INFO mapreduce.Job:  map 100% reduce 100%
17/03/26 00:27:53 INFO mapreduce.Job: Job job_local1240936221_0001 completed successfully
17/03/26 00:27:53 INFO mapreduce.Job: Counters: 35
	File System Counters
		FILE: Number of bytes read=299576
		FILE: Number of bytes written=1382274
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=4443314
		HDFS: Number of bytes written=18
		HDFS: Number of read operations=22
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=5
	Map-Reduce Framework
		Map input records=13130
		Map output records=13129
		Map output bytes=118161
		Map output materialized bytes=144431
		Input split bytes=224
		Combine input records=0
		Combine output records=0
		Reduce input groups=2
		Reduce shuffle bytes=144431
		Reduce input records=13129
		Reduce output records=2
		Spilled Records=26258
		Shuffled Maps =2
		Failed Shuffles=0
		Merged Map outputs=2
		GC time elapsed (ms)=4
		Total committed heap usage (bytes)=1012924416
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=1777168
	File Output Format Counters
		Bytes Written=18

```

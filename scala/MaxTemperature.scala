// cc MaxTemperature Application to find the maximum temperature in the weather dataset
// vv MaxTemperature
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// For getConf()
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
// import MaxTemperatureReducer.*;
// import MaxTemperatureMapper.*;




object MaxTemperature {

    @throws(classOf[Exception])
    def main(args: Array[String]) {
    //public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: MaxTemperature <input path> <output path>");
            System.exit(-1);
        }

        // val job = new Job();
        val conf = new Configuration();
        val job = Job.getInstance(conf, "MaxTemperature Scala.")
        //job.setJarByClass(MaxTemperature.class);
        job.setJarByClass(MaxTemperature.getClass);
        job.setJobName("Max temperature");

        FileInputFormat.addInputPath(job, new Path(args(0)));
        FileOutputFormat.setOutputPath(job, new Path(args(1)));

        job.setMapperClass(classOf[MaxTemperatureMapper]);
        job.setReducerClass(classOf[MaxTemperatureReducer]);

        job.setOutputKeyClass(classOf[Text]);
        job.setOutputValueClass(classOf[IntWritable]);

        System.exit(if (job.waitForCompletion(true)) 0 else 1);
    }
}
// ^^ MaxTemperature

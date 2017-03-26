// cc MaxTemperatureMapper Mapper for maximum temperature example
// vv MaxTemperatureMapper
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

class MaxTemperatureMapper
   extends Mapper[LongWritable, Text, Text, IntWritable] {

   //private static final int MISSING = 9999;

   // @Override
   // public void map(LongWritable key, Text value, Context context)
   //     throws IOException, InterruptedException {

   @throws(classOf[Exception])
   @Override
   def map(key : LongWritable, value : Text, context : Context) {

       val MISSING : Int = 9999;
       val line : String = value.toString;
       val year : String = line.substring(15, 19);
       var airTemperature : Int = 0;
       if (line(87) == '+') { // parseInt doesn't like leading plus signs
           airTemperature = Integer.parseInt(line.substring(88, 92));
       } else {
           airTemperature = Integer.parseInt(line.substring(87, 92));
       }
       val quality : String = line.substring(92, 93);
       if (airTemperature != MISSING && quality.matches("[01459]")) {
           context.write(new Text(year), new IntWritable(airTemperature));
       }
    }
}


// ^^ MaxTemperatureMapper

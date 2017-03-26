// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

class MaxTemperatureReducer
  extends Reducer[Text, IntWritable, Text, IntWritable] {

  @throws(classOf[Exception])
  @Override
  def reduce(key : Text, values : Iterable[IntWritable], context : Context){

      var maxValue : Int = Integer.MIN_VALUE;
      for (value <- values) {
          maxValue = Math.max(maxValue, value.get());
      }
      context.write(key, new IntWritable(maxValue));
    }
}
// ^^ MaxTemperatureReducer

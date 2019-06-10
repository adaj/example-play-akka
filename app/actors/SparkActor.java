package actors;

import akka.actor.*;

import java.util.*;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;

public class SparkActor extends AbstractActor {

    public Integer num = 0;

    public SparkActor() {
	SparkConf conf = new SparkConf(true)//
				.setAppName("MyApp")//
				.setMaster("spark://mestrado-06:7077");		
   	JavaSparkContext sc = new JavaSparkContext(conf);
    	JavaRDD<Integer> numbers = sc.parallelize(Arrays.asList(14,21,88,99,455)); 
	num = numbers.first();
	sc.close();
        
    }

    static public Props props() {
      return Props.create(SparkActor.class);
    }

    


    @Override
    public Receive createReceive() {
	return receiveBuilder()//
	                .match(String.class, s -> {
				sender().tell(s+", I'm an actor using Spark! The first element of the RDD is "+ String.valueOf(num), self());
			})
		        .build();
    }
}

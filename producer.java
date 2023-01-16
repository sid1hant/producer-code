 import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;


public class MyProducer {


   public static void main(String[] args) {


   //step1 -set properties

   //client-id,bootstrap server list,set key serializer class, value serialzer class (appropriate serializer class --sent the msg over the network but should be in serialized form, msg are in key value pair)
   
  // 1, "this is first msg"--have written for this msg
   Properties props=new Properties();
   props.put(ProducerConfig.CLIENT_ID_CONFIG,"producer-id1")
   props.put(ProducerConfig.BOOTSTRAP_SERVER_CONFIG,"localhost:9092,localhost:9093")
   props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,IntegerSerialzer.class.getName());
   props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerialzer.class.getName());
   

  //step2-create object of kafka producer

   KafkaProducer<Integer,String> producer = new KafkaProducer<Integer,String>(props);
   

 // step3 - calling the sent methon on producer object
 
   producer.send(new ProducerRecord<Integer,String>("newtopic",1,"this is my first msg"));

 //step 4 close the producer object

   producer.close();


  
   




}



}

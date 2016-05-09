package springRedisExample;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;


public class TestIf {

	public static void main(String[] args) {
		 Jedis j = new Jedis("192.168.99.100", 6379);
	        j.connect();
	        System.out.println("Connected");
	        behaveAsMapOfMaps(j);
		

	}

	  public static void behaveAsMapOfMaps(Jedis j) {
	        System.out.println("\n[Map<String, Map<String, String>>]");

	        j.hset("user_1", "name", "doh!");
	        j.hset("user_1", "age", "39");

	        Pipeline pipe=j.pipelined();
	        pipe.hset("user_2", "name", "burns");
	        pipe.hset("user_2", "age", "129");
	        pipe.hset("user_2", "net_worth", "high");

	        pipe.hset("user_3", "name", "marge");
	        pipe.hset("user_3", "age", "38");
	        pipe.hset("user_3", "kids", "2");
	        
	        pipe.syncAndReturnAll();
	        
	        Map<String, String> map= j.hgetAll("user_1");
	        for(Map.Entry<String, String> et:   map.entrySet()){
	        	System.out.println("The key :"+et.getKey());
	        	System.out.println("The value :"+et.getValue());
	        }
	        
	        print("hgetAll(\"user_1\")", j.hgetAll("user_1"));
	        print("hgetAll(\"user_2\")", j.hgetAll("user_2"));
	        print("hgetAll(\"user_3\")", j.hgetAll("user_3"));
	    }
	  static void print(String command, Object result) {
	        System.out.printf("%-55s:  %s%n", command, result);
	    }

}

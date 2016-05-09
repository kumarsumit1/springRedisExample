package springRedisExample;

import org.apache.log4j.Logger;



public class App {
	 private static final Logger LOGGER = Logger.getLogger(App.class);
	 
	    public static void main(String[] args) {
	        for (int i = 0; i < 10; i++) {
	            try {	                LOGGER.debug("Hello World " + i);
	                Thread.sleep(5000);
	            } catch (Exception e) {
	            }
	        }
	    }
}

package sampletest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jExample {
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);
    
    @Test
    public static void main() {
        logger.info("This is an INFO message");
        logger.error("This is an ERROR message");
        
    }
}
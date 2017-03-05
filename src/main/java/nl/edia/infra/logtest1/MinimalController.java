package nl.edia.infra.logtest1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinimalController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllServers(){
        logger.info("This is an {} message.","info");
        logger.warn("This is a warn message.");
        logger.error("This is an error message.");
        logger.debug("This is a debug message.");
        logger.trace("This is a trace message.");
        
        // testing a stacktrace
        try { 
            // Try block to handle code that may cause exception
            int a = 42 / 0;
         } catch (ArithmeticException e) {
        	 logger.error("Exception foo bar...", e);
         }
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
        
        
    }
}

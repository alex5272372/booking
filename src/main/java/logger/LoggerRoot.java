package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerRoot {
    private static final Logger logger = LoggerFactory.getLogger(LoggerRoot.class);

    public void printAction(String actionName, String action){
        logger.info("User enter " + actionName +": " + action);
    }
}

package org.blackberry020.rest.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
class CalculateExecutionTimeLogger {

    private static final Logger logger = LoggerFactory.getLogger(CalculateExecutionTimeLogger.class);

    public void log(StopWatch stopWatch) {
        stopWatch.stop();
        long elapsedMillis = stopWatch.getTotalTimeMillis();
        logger.info("Request processing time (ms): " + elapsedMillis);
    }
}

package org.blackberry020.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalculateRequestLogger {
    private static final Logger logger = LoggerFactory.getLogger(CalculateRequestLogger.class);

    void log(TravelCalculatePremiumRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(request);
            logger.info("REQUEST: " + json);
        } catch (JsonProcessingException e) {
            logger.error("Error to convert request to JSON", e);
        }
    }
}

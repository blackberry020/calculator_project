package org.blackberry020.rest;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.CalculateResponse;
import org.blackberry020.core.services.CalculationService;

import org.blackberry020.rest.loggers.CalculateRequestExecutionTimeLogger;
import org.blackberry020.rest.loggers.CalculateRequestLogger;
import org.blackberry020.rest.loggers.CalculateResponseLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator/calculate")
public class CalculatorController {

    @Autowired private CalculateRequestLogger requestLogger;
    @Autowired private CalculateResponseLogger responseLogger;
    @Autowired private CalculateRequestExecutionTimeLogger executionTimeLogger;
    @Autowired private CalculationService calculationService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public CalculateResponse calculatePremium(@RequestBody CalculateRequest request) {
        StopWatch stopwatch = new StopWatch();

        stopwatch.start();
        CalculateResponse response = processRequest(request);
        stopwatch.stop();

        executionTimeLogger.log(stopwatch);
        return response;
    }

    private CalculateResponse processRequest(CalculateRequest request) {
        requestLogger.log(request);
        CalculateResponse response = calculationService.calculate(request);
        responseLogger.log(response);
        return response;
    }

}
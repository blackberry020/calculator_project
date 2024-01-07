package org.blackberry020.rest;

import org.blackberry020.dto.CalculationRequest;
import org.blackberry020.dto.CalculationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance/travel")
public class CalculatorController {

    @Autowired private CalculationService calculationService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public CalculationResponse calculatePremium(@RequestBody CalculationRequest request) {
        CalculationResponse response = calculationService.calculate(request);
        return response;
    }

}
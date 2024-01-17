package org.blackberry020.rest;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.CalculateResponse;
import org.blackberry020.core.services.CalculationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator/calculate")
public class CalculatorController {

    @Autowired private CalculationService calculationService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public CalculateResponse calculatePremium(@RequestBody CalculateRequest request) {
        return calculationService.calculate(request);
    }

}
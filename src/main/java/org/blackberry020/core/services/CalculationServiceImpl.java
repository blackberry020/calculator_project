package org.blackberry020.core.services;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.CalculateResponse;
import org.springframework.stereotype.Component;

@Component
class CalculationServiceImpl implements CalculationService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        return new CalculateResponse(0);
    }
}

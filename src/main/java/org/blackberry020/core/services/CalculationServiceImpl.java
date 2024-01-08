package org.blackberry020.core.services;

import org.blackberry020.core.validation.CalculateRequestValidator;
import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.CalculateResponse;
import org.blackberry020.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
class CalculationServiceImpl implements CalculationService {

    @Autowired
    private CalculateRequestValidator requestValidator;

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        List<ValidationError> errors = requestValidator.validate(request);
        return errors.isEmpty() ? buildResponse(request) : buildResponse(errors);
    }

    CalculateResponse buildResponse(List<ValidationError> errors) {
        return new CalculateResponse(errors);
    }

    CalculateResponse buildResponse(CalculateRequest request) {
        return new CalculateResponse(1.5);
    }
}

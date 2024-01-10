package org.blackberry020.core.validation;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CalculateRequestValidationImpl implements CalculateRequestValidation {
    @Override
    public Optional<ValidationError> check(CalculateRequest request) {
        return Optional.empty();
    }

    @Override
    public List<ValidationError> checkList(CalculateRequest request) {
        return null;
    }
}

package org.blackberry020.core.validation;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract class CalculateRequestValidationImpl implements CalculateRequestValidation {
    @Override
    public Optional<ValidationError> check(CalculateRequest request) {
        return Optional.empty();
    }

    @Override
    public List<ValidationError> checkList(CalculateRequest request) {
        return null;
    }
}

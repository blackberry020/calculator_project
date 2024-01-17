package org.blackberry020.core.validation;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;

import java.util.List;
import java.util.Optional;

interface CalculateRequestValidation {
    Optional<ValidationError> check(CalculateRequest request);

    List<ValidationError> checkList(CalculateRequest request);
}

package org.blackberry020.core.validation;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.ValidationError;

import java.util.Optional;

interface CalculateRequestValidation {
    Optional<ValidationError> check(CalculateRequest request);
}

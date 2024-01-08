package org.blackberry020.core.validation;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.ValidationError;

import java.util.Optional;

public interface CalculateRequestValidation {
    Optional<ValidationError> check(CalculateRequest request);
}

package org.blackberry020.core.validation;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;

import java.util.List;

public interface CalculateRequestValidator {
    List<ValidationError> validate(CalculateRequest request);
}

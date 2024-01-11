package org.blackberry020.core.validation;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class ExtensionValidation extends CalculateRequestValidationImpl {

    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> check(CalculateRequest request) {
        return (!request.getExtension().matches("^((txt)|(xml)|(json)|(rar)|(zip))$"))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_1", request.getExtension()))
                : Optional.empty();
    }
}
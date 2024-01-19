package org.blackberry020.core.validation;

import org.blackberry020.app.dto.ValidationError;
import org.blackberry020.core.util.ErrorCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationErrorFactory {

    @Autowired
    private ErrorCodeUtil errorCodeUtil;

    public ValidationError buildError(String errorCode) {
        return new ValidationError(
                errorCode,
                errorCodeUtil.getErrorDescription(errorCode)
        );
    }

    public ValidationError buildError(String errorCode, String placeholder) {
        return new ValidationError(
                errorCode,
                errorCodeUtil.getErrorDescription(errorCode, placeholder)
        );
    }
}

package org.blackberry020.core.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
@Getter
class CalculateRequestValidatorImpl implements CalculateRequestValidator {

    @Autowired
    private List<CalculateRequestValidation> validations;

    @Override
    public List<ValidationError> validate(CalculateRequest request) {
        return validations.stream()
                .map(x -> x.check(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}

package org.blackberry020.core.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
@Component
@Getter
class CalculateRequestValidatorImpl implements CalculateRequestValidator {

    @Autowired
    private List<CalculateRequestValidation> validations;

    @Override
    public List<ValidationError> validate(CalculateRequest request) {
        List<ValidationError> singleErrors = collectSingleErrors(request);
        List<ValidationError> listErrors = collectListErrors(request);
        return concatenateLists(singleErrors, listErrors);
    }

    private List<ValidationError> collectSingleErrors(CalculateRequest request) {
        return validations.stream()
                .map(validation -> validation.check(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<ValidationError> collectListErrors(CalculateRequest request) {
        return validations.stream()
                .map(validation -> validation.checkList(request))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<ValidationError> concatenateLists(List<ValidationError> singleErrors,
                                                   List<ValidationError> listErrors) {
        return Stream.concat(singleErrors.stream(), listErrors.stream())
                .collect(Collectors.toList());
    }
}

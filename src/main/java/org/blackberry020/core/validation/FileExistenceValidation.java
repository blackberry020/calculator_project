package org.blackberry020.core.validation;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Component
class FileExistenceValidation implements CalculateRequestValidation {

    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> check(CalculateRequest request) {

        Path path = Paths.get(request.getFilePath());

        return (Files.notExists(path))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_2"))
                : Optional.empty();
    }
}

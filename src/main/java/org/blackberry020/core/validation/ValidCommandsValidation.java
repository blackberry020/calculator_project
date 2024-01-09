package org.blackberry020.core.validation;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Component
public class ValidCommandsValidation implements CalculateRequestValidation {

    @Autowired
    private ValidationErrorFactory errorFactory;

    private final ArrayList<String> availableRequestCommands = new ArrayList<>(Arrays.asList("DECOMPRESS", "DECRYPT"));
    private final ArrayList<String> availableResponseCommands = new ArrayList<>(Arrays.asList("COMPRESS", "ENCRYPT"));

    @Override
    public Optional<ValidationError> check(CalculateRequest request) {

        ArrayList<String> commands = request.getCommands();
        if (commands.isEmpty()) return Optional.empty();

        for (String command : commands) {
            if (!availableRequestCommands.contains(command)) {
                return Optional.of(errorFactory.buildError("ERROR_CODE_3"));
            }
        }

        return Optional.empty();
    }
}

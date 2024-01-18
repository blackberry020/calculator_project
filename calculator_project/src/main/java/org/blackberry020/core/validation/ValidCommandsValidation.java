package org.blackberry020.core.validation;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ValidCommandsValidation extends CalculateRequestValidationImpl {

    @Autowired
    private ValidationErrorFactory errorFactory;

    private final ArrayList<String> availableRequestCommands = new ArrayList<>(Arrays.asList("DECOMPRESS", "DECRYPT"));

    @Override
    public List<ValidationError> checkList(CalculateRequest request) {

        List<String> commands = request.getCommands();
        ArrayList<ValidationError> errors = new ArrayList<>();

        if (commands.isEmpty()) return errors;

        for (String command : commands) {
            if (!availableRequestCommands.contains(command)) {
                errors.add(errorFactory.buildError("ERROR_CODE_3", command));
            }
        }

        return errors;
    }
}

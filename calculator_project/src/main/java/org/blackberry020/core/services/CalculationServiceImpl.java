package org.blackberry020.core.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.blackberry020.app.base64Converter.BaseConverter;
import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.CalculateResponse;
import org.blackberry020.app.dto.ValidationError;
import org.blackberry020.core.AlgebraicExpression;
import org.blackberry020.core.processor.entity.CoreEntity;
import org.blackberry020.core.evaluation.Calculator;
import org.blackberry020.core.processor.CommandProcessorComponent;
import org.blackberry020.core.processor.cmd.ManipulationCommand;
import org.blackberry020.core.readers.Reader;
import org.blackberry020.core.readers.ReaderFactory;
import org.blackberry020.core.util.CommandMapperUtil;
import org.blackberry020.core.validation.CalculateRequestValidator;
import org.blackberry020.core.validation.ValidationErrorFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
class CalculationServiceImpl implements CalculationService {

    private final CalculateRequestValidator requestValidator;

    private final BaseConverter baseConverter;

    private final CommandMapperUtil commandMapperUtil;

    private final CommandProcessorComponent commandProcessor;

    private final ValidationErrorFactory errorFactory;

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        List<ValidationError> errors = requestValidator.validate(request);
        return errors.isEmpty() ? buildResponse(request) : buildResponse(errors);
    }

    CalculateResponse buildResponse(List<ValidationError> errors) {
        return new CalculateResponse(errors);
    }

    CalculateResponse buildResponse(CalculateRequest request) {
        byte[] fileContent = baseConverter.convertBase64ToFile(request.getFileBase64());

        List<ManipulationCommand> commands = commandMapperUtil.mapCommandsToList(request.getCommands());
        String finalContent;

        try {
            finalContent = getFinalFile(fileContent, commands);
        }
        catch (Exception e) {
            log.error("Error getting final file: " + e.getMessage());
            return new CalculateResponse(List.of(errorFactory.buildError("ERROR_CODE_5")));
        }

        Reader reader = ReaderFactory.getReader(request.getExtension());
        AlgebraicExpression expression = null;

        try {
            expression = reader.read(finalContent);
        }
        catch (Exception e) {
            log.error("Error parsing the final file: " + e.getMessage());
            return new CalculateResponse(List.of(errorFactory.buildError("ERROR_CODE_6")));
        }

        double result = 0;

        try {
            result = calculateExpression(expression);
        }
        catch (Exception e) {
            log.error("Error calculating the expression: " + e.getMessage());
            return new CalculateResponse(List.of(errorFactory.buildError("ERROR_CODE_7")));
        }

        return new CalculateResponse(result);
    }

    private String getFinalFile(byte[] content, List<ManipulationCommand> commands) throws Exception {
        String finalContent = commandProcessor.execute(
                new CoreEntity(content),
                commands
        ).getTextRepresentation();

        log.info(finalContent);

        return finalContent;
    }

    private double calculateExpression(AlgebraicExpression algebraicExpression) throws Exception {
        return Calculator.calculate(algebraicExpression);
    }
}

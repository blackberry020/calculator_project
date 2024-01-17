package org.blackberry020.core.validation;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidCommandsValidationTest {

    @Mock
    private CalculateRequest request;

    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    private ValidCommandsValidation validation;

    @Test
    public void returnNothingIfThereAreNoCommands() {
        when(request.getCommands()).thenReturn(new ArrayList<>());
        List<ValidationError> errors = validation.checkList(request);
        assertEquals(new ArrayList<>(), errors);
    }

    @Test
    public void returnNothingIfCommandsAreOk() {
        when(request.getCommands()).thenReturn(new ArrayList<>(List.of("DECRYPT", "DECOMPRESS")));
        List<ValidationError> errors = validation.checkList(request);
        assertEquals(new ArrayList<>(), errors);
    }

    @Test
    public void returnErrorIfThereIsOneWrongCommand() {
        when(request.getCommands()).thenReturn(new ArrayList<>(List.of("ENCRYPT", "DECRYPT")));
        when(errorFactory.buildError(any(), any())).thenReturn(new ValidationError());
        assertEquals(
                new ArrayList<>(
                        List.of(new ValidationError())
                ),
                validation.checkList(request)
        );
    }

    @Test
    public void returnErrorsIfAllCommandsAreWrong() {
        when(request.getCommands()).thenReturn(new ArrayList<>(List.of("ENCRYPT", "COMPRESS")));
        when(errorFactory.buildError(any(), any())).thenReturn(new ValidationError());
        assertEquals(
                new ArrayList<>(
                        List.of(new ValidationError(), new ValidationError())
                ),
                validation.checkList(request)
        );
    }
}


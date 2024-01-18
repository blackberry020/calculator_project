package org.blackberry020.core.validation;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FileNotEmptyValidationTest {

    @Mock
    private CalculateRequest request;

    @Mock
    private ValidationErrorFactory errorFactory;

    @InjectMocks
    private FileNotEmptyValidation validation;

    @Test
    public void returnErrorIfFileIsNull() {
        when(request.getFileBase64()).thenReturn(null);
        when(errorFactory.buildError(any())).thenReturn(new ValidationError());

        Optional<ValidationError> expected = Optional.of(new ValidationError());
        Optional<ValidationError> error = validation.check(request);

        assertEquals(expected, error);
    }

    @Test
    public void returnErrorIfFileIsEmpty() {
        when(request.getFileBase64()).thenReturn("    ");
        when(errorFactory.buildError(any())).thenReturn(new ValidationError());

        Optional<ValidationError> expected = Optional.of(new ValidationError());
        Optional<ValidationError> error = validation.check(request);

        assertEquals(expected, error);
    }

    @Test
    public void returnNothingIfFileIsOk() {
        when(request.getFileBase64()).thenReturn("txt");

        Optional<ValidationError> error = validation.check(request);
        assertEquals(Optional.empty(), error);
    }
}

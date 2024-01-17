package org.blackberry020.core.validation;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRequestValidatorTest {

    @Mock
    private CalculateRequest request;

    @InjectMocks
    private CalculateRequestValidatorImpl validator;

    @Test
    public void returnNothingIfEverythingIsOk() {
        CalculateRequestValidation validation1 = mock(CalculateRequestValidation.class);
        when(validation1.check(request)).thenReturn(Optional.empty());

        CalculateRequestValidation validation2 = mock(CalculateRequestValidation.class);
        when(validation2.check(request)).thenReturn(Optional.empty());

        List<CalculateRequestValidation> validations = List.of(
                validation1, validation2
        );

        ReflectionTestUtils.setField(validator, "validations", validations);
        List<ValidationError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void returnErrorsIfEverythingNotOk() {
        CalculateRequestValidation validation1 = mock(CalculateRequestValidation.class);
        when(validation1.check(request)).thenReturn(Optional.of(
                new ValidationError("field", "message")
        ));

        CalculateRequestValidation validation2 = mock(CalculateRequestValidation.class);
        when(validation2.check(request)).thenReturn(Optional.of(
                new ValidationError("field", "message")
        ));

        List<CalculateRequestValidation> validations = List.of(
                validation1, validation2
        );

        ReflectionTestUtils.setField(validator, "validations", validations);
        List<ValidationError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
    }
}


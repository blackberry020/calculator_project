package org.blackberry020.core.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ErrorCodeUtilTest {

    @Mock
    private Properties props;

    @InjectMocks
    private ErrorCodeUtil errorCodeUtil;

    @Test
    public void shouldGetErrorDescription() {
        when(props.getProperty("ERROR_CODE")).thenReturn("error description");
        assertEquals(
                "error description",
                errorCodeUtil.getErrorDescription("ERROR_CODE")
        );
    }

    @Test
    public void shouldGetErrorDescriptionWithPlaceholder() {
        when(props.getProperty("ERROR_CODE")).thenReturn("error {0} description");
        assertEquals(
                errorCodeUtil.getErrorDescription("ERROR_CODE", "A1"),
                "error A1 description"
        );
    }

}
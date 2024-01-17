package org.blackberry020.core.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

@Component
@Getter
@Setter
@AllArgsConstructor
public class ErrorCodeUtil {
    private final Properties properties;

    ErrorCodeUtil() throws IOException {
        Resource resource = new ClassPathResource("errorCodes.properties");
        properties = PropertiesLoaderUtils.loadProperties(resource);
    }

    public String getErrorDescription(String errorCode) {
        return properties.getProperty(errorCode);
    }

    public String getErrorDescription(String errorCode, String placeholder) {
        return MessageFormat.format(properties.getProperty(errorCode), placeholder);
    }
}

package org.blackberry020.core.processor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@AllArgsConstructor
@Getter
@Setter
public class CoreEntity {
    byte[] data;
    public String getTextRepresentation() throws UnsupportedEncodingException {
        return new String(data, StandardCharsets.UTF_8);
    }
}

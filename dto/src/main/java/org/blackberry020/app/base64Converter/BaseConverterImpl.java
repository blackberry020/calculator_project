package org.blackberry020.app.base64Converter;

import java.util.Base64;

public class BaseConverterImpl implements BaseConverter {
    @Override
    public String convertFileToBase64(byte[] fileContent) {
        return Base64.getEncoder().encodeToString(fileContent);
    }

    @Override
    public byte[] convertBase64ToFile(String baseContent) {
        return  Base64.getDecoder().decode(baseContent);
    }
}

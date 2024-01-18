package org.blackberry020.app.base64Converter;

import java.io.IOException;
import java.util.Base64;

public class BaseConverterImpl implements BaseConverter {
    @Override
    public byte[] convertFileToBase64(byte[] fileContent) throws IOException {
        return Base64.getEncoder().encode(fileContent);
    }

    @Override
    public byte[] convertBase64ToFile(byte[] baseContent) throws IOException {
        return  Base64.getDecoder().decode(baseContent);
    }
}

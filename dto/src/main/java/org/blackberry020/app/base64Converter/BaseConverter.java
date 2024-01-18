package org.blackberry020.app.base64Converter;

import java.io.IOException;

public interface BaseConverter {

    public String convertFileToBase64(byte[] fileContent);
    public byte[] convertBase64ToFile(String baseContent);
}

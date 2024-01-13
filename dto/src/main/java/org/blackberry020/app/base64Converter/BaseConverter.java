package org.blackberry020.app.base64Converter;

import java.io.IOException;

public interface BaseConverter {

    public String convertFileToBase64(String filePath) throws IOException;
    public String convertBase64ToFile(String data, String extension) throws IOException;
}

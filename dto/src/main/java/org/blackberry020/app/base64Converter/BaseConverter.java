package org.blackberry020.app.base64Converter;

import java.io.IOException;

public interface BaseConverter {

    public byte[] convertFileToBase64(byte[] fileContent) throws IOException;
    public byte[] convertBase64ToFile(byte[] baseContent) throws IOException;
}

package org.blackberry020.app.base64Converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

public class BaseConverterImpl implements BaseConverter {
    @Override
    public String convertFileToBase64(String filePath) throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
        //System.out.println("data in file: " + Arrays.toString(fileContent));
        //System.out.println("encoded string: " + Base64.getEncoder().encodeToString(fileContent));
        return Base64.getEncoder().encodeToString(fileContent);
    }

    @Override
    public String convertBase64ToFile(String data, String extension) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        String filePath = "file." + extension;
        Files.write(Paths.get(filePath), decodedBytes);

        return filePath;
    }
}

package org.blackberry020.app.base64Converter;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BaseConverterImplTest {

    private final BaseConverterImpl baseConverter;

    BaseConverterImplTest() {
        baseConverter = new BaseConverterImpl();
    }

    @Test
    public void fileToBaseAndBackContentMustBeTheSame() throws IOException {
        String fileName = "testFile.txt";
        String content = "hi there I'm Alice";

        createFile(fileName);
        writeContent(fileName, content);

        byte[] baseFile = baseConverter.convertFileToBase64(content.getBytes());
        byte[] decodedFile = baseConverter.convertBase64ToFile(baseFile);

        assertArrayEquals(content.getBytes(), decodedFile);

        deleteFile(fileName);
    }

    @Test
    public void fileZipToBaseAndBackContentMustBeTheSame() throws IOException, URISyntaxException {
        String fileName = "input.zip";
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        byte[] content = is.readAllBytes();

        is.close();

        byte[] baseFile = baseConverter.convertFileToBase64(content);
        byte[] decodedFile = baseConverter.convertBase64ToFile(baseFile);

        assertArrayEquals(content, decodedFile);
    }

    private void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.createNewFile()) {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("error while creating file: " + e.getMessage());
        }
    }

    private void writeContent(String fileName, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing content to file: " + e.getMessage());
        }
    }

    private byte[] getContent(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(fileName));
        }
        catch (IOException e) {
            System.out.println("Failed to get file content: " + e.getMessage());
        }

        return new byte[0];
    }

    private void deleteFile(String fileName) {
        File file = new File(fileName);
        if (!file.delete()) {
            System.out.println("Couldn't find file " + fileName);
        }
    }
}

package org.blackberry020.core.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {
    public static String read(String filePath) {

        StringBuilder builder = new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {

            String str;

            while ((str = buffer.readLine()) != null) {
                builder.append(str).append('\n');
            }

            if (!builder.isEmpty())
                builder = new StringBuilder(builder.substring(0, builder.length() - 1));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return builder.toString();
    }
}

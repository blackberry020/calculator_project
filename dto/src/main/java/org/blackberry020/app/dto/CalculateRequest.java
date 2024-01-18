package org.blackberry020.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.blackberry020.app.base64Converter.BaseConverter;
import org.blackberry020.app.base64Converter.BaseConverterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculateRequest {
    String file;
    String extension;
    ArrayList<String> commands;

    public CalculateRequest(String filePath, List<String> actions) throws IOException {
        BaseConverter baseConverter = new BaseConverterImpl();

        /*try {
            file = baseConverter.convertFileToBase64(filePath);
            extension = filePath.substring(filePath.lastIndexOf('.' + 1));
        }
        catch (IOException e) {
            System.out.println("file " + e.getMessage() + " wasn't found");
        }
        finally {
            System.out.println("file problem while encoding to base64");
        }

        commands = (ArrayList<String>) actions;*/
    }
}

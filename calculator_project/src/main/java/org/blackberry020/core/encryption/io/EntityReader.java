package org.blackberry020.core.encryption.io;

import org.blackberry020.core.encryption.entity.CoreEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class EntityReader {
    public CoreEntity readEntity(String pathFile) throws IOException {
        File file = new File(pathFile);
        Path path = Paths.get(file.getAbsolutePath());

        return new CoreEntity(
                        Files.readAllBytes(path)
                );
    }
}

package org.blackberry020.encryption.io;

import org.blackberry020.encryption.entity.CoreEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EntityReader {
    public CoreEntity readEntity(String pathFile) throws IOException {
        File file = new File(pathFile);
        Path path = Paths.get(file.getAbsolutePath());

        return new CoreEntity(
                        Files.readAllBytes(path)
                );
    }
}

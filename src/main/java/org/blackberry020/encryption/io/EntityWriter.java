package org.blackberry020.encryption.io;

import org.blackberry020.encryption.entity.CoreEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EntityWriter {
    public void saveEntity(String pathFile, CoreEntity coreEntity) throws IOException {
        Path path = Paths.get(pathFile);
        Files.write(path, coreEntity.getData());
    }
}

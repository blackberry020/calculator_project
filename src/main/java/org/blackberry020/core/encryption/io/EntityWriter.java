package org.blackberry020.core.encryption.io;

import org.blackberry020.core.encryption.entity.CoreEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class EntityWriter {
    public void saveEntity(String pathFile, CoreEntity coreEntity) throws IOException {
        Path path = Paths.get(pathFile);
        Files.write(path, coreEntity.getData());
    }
}

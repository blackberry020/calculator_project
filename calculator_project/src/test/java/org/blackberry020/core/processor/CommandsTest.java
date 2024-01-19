package org.blackberry020.core.processor;

import org.blackberry020.core.processor.cmd.CompressCommand;
import org.blackberry020.core.processor.cmd.DecompressCommand;
import org.blackberry020.core.processor.cmd.DecryptCommand;
import org.blackberry020.core.processor.cmd.EncryptCommand;
import org.blackberry020.core.processor.entity.CoreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommandsTest {

    @Autowired
    private CommandProcessor commandProcessor;

    @Autowired
    private EncryptCommand encryptCommand;

    @Autowired
    private DecryptCommand decryptCommand;

    @Autowired
    private CompressCommand compressCommand;

    @Autowired
    private DecompressCommand decompressCommand;

    @Test
    public void encryptedAndThenDecryptedFileMustStayTheSame() throws Exception {
        String fileContent = "hi there I'm Alice";

        String result = commandProcessor.execute(
                new CoreEntity(fileContent.getBytes()),
                List.of(encryptCommand, decryptCommand)
        ).getTextRepresentation();

        assertEquals(fileContent, result);
    }

    @Test
    public void compressedAndThenDecompressedFileMustStayTheSame() throws Exception {
        String fileContent = "hi there I'm Alice";

        String result = commandProcessor.execute(
                new CoreEntity(fileContent.getBytes()),
                List.of(compressCommand, decompressCommand)
        ).getTextRepresentation();

        assertEquals(fileContent, result);
    }
}

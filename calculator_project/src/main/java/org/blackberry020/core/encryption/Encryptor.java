package org.blackberry020.core.encryption;

import org.blackberry020.core.encryption.entity.CoreEntity;
import org.blackberry020.core.encryption.io.EntityReader;
import org.blackberry020.core.encryption.io.EntityWriter;
import org.blackberry020.core.encryption.key.source.GeneratedKeySource;
import org.blackberry020.core.encryption.key.writer.BinaryKeyWriter;
import org.blackberry020.core.processor.CommandProcessor;
import org.blackberry020.core.processor.cmd.DecryptCommand;
import org.blackberry020.core.processor.cmd.EncryptCommand;
import org.blackberry020.core.processor.cmd.ManipulationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;

@Component
public class Encryptor {
    static final String transformation = "AES/ECB/PKCS5Padding";

    @Autowired
    private EntityReader reader;

    @Autowired
    private EntityWriter entityWriter;

    private final SecretKey secretKey;

    public Encryptor() throws NoSuchAlgorithmException {
        secretKey = new GeneratedKeySource("AES", 128).getKey();
    }

    public void encrypt(String filePath) throws Exception {
        CoreEntity entity = reader.readEntity(filePath);

        writeKeyToFile(secretKey);

        ManipulationCommand encryptCommand = new EncryptCommand(
                Cipher.getInstance(transformation),
                secretKey
        );

        CommandProcessor commandProcessor = new CommandProcessor(entity)
                .addCommand(encryptCommand);

        CoreEntity outEntity = commandProcessor.execute();
        entityWriter.saveEntity(filePath, outEntity);
    }

    public void decrypt(String filePath) throws Exception {
        CoreEntity entity = reader.readEntity(filePath);

        writeKeyToFile(secretKey);

        ManipulationCommand decryptCommand = new DecryptCommand(
                Cipher.getInstance(transformation),
                secretKey
        );

        CommandProcessor commandProcessor = new CommandProcessor(entity)
                .addCommand(decryptCommand);

        CoreEntity outEntity = commandProcessor.execute();
        entityWriter.saveEntity(filePath, outEntity);
    }

    private static void writeKeyToFile(SecretKey secretKey) throws Exception {
        BinaryKeyWriter writer = new BinaryKeyWriter(
                new FileOutputStream("latestSecretKeyJavaObject")
        );
        writer.writeKey(secretKey);
    }
}

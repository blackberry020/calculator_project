package org.blackberry020.encryption;

import org.blackberry020.encryption.entity.CoreEntity;
import org.blackberry020.encryption.io.EntityReader;
import org.blackberry020.encryption.io.EntityWriter;
import org.blackberry020.encryption.key.source.GeneratedKeySource;
import org.blackberry020.encryption.key.writer.BinaryKeyWriter;
import org.blackberry020.encryption.processor.CommandProcessor;
import org.blackberry020.encryption.processor.cmd.DecryptCommand;
import org.blackberry020.encryption.processor.cmd.EncryptCommand;
import org.blackberry020.encryption.processor.cmd.ManipulationCommand;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;

public class Encryptor {
    static final String transformation = "AES/ECB/PKCS5Padding";

    public void encrypt(String filePath) throws Exception {
        EntityReader reader = new EntityReader();
        EntityWriter entityWriter = new EntityWriter();

        CoreEntity entity = reader.readEntity(filePath);

        SecretKey secretKey = new GeneratedKeySource("AES", 128).getKey();

        writeKeyToFile(secretKey);


        ManipulationCommand encryptCommand = new EncryptCommand(
                Cipher.getInstance(transformation),
                secretKey
        );

        /*ManipulationCommand decryptCommand = new DecryptCommand(
                Cipher.getInstance(transformation),
                secretKey
        );*/

        CommandProcessor commandProcessor = new CommandProcessor(entity)
                .addCommand(encryptCommand);
        //.addCommand(decryptCommand);

        CoreEntity outEntity = commandProcessor.execute();
        entityWriter.saveEntity("finalTextFile.txt", outEntity);
    }

    private static void writeKeyToFile(SecretKey secretKey) throws Exception {
        BinaryKeyWriter writer = new BinaryKeyWriter(
                new FileOutputStream("latestSecretKeyJavaObject")
        );
        writer.writeKey(secretKey);
    }
}

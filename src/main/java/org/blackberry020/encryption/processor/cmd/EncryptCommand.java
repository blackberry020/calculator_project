package org.blackberry020.encryption.processor.cmd;

import lombok.AllArgsConstructor;
import org.blackberry020.encryption.entity.CoreEntity;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;

@AllArgsConstructor
public class EncryptCommand implements ManipulationCommand {

    Cipher cipher;
    SecretKey secretKey;

    @Override
    public CoreEntity process(CoreEntity entity) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(entity.getData());
        return new CoreEntity(encryptedBytes);
    }
}

package org.blackberry020.encryption.processor.cmd;

import lombok.AllArgsConstructor;
import org.blackberry020.encryption.entity.CoreEntity;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;

@AllArgsConstructor
public class DecryptCommand implements ManipulationCommand {

    Cipher cipher;
    SecretKey secretKey;

    @Override
    public CoreEntity process(CoreEntity entity) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(entity.getData());
        return new CoreEntity(decryptedBytes);
    }
}

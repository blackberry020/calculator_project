package org.blackberry020.core.processor.cmd;

import lombok.AllArgsConstructor;
import org.blackberry020.core.processor.entity.CoreEntity;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;

@Component
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

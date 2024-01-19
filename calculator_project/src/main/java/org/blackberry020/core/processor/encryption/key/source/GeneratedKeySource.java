package org.blackberry020.core.processor.encryption.key.source;

import lombok.AllArgsConstructor;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
public class GeneratedKeySource implements SecretKeySource {
    String algorithm;
    int keySize;
    public SecretKey getKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(keySize);

        return keyGenerator.generateKey();
    }
}

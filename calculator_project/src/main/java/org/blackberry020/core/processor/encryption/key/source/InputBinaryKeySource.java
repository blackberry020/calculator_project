package org.blackberry020.core.processor.encryption.key.source;

import lombok.AllArgsConstructor;

import javax.crypto.SecretKey;
import java.io.InputStream;
import java.io.ObjectInputStream;

@AllArgsConstructor
public class InputBinaryKeySource implements SecretKeySource{

    InputStream inputStream;
    @Override
    public SecretKey getKey() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        SecretKey secretKey = (SecretKey) ois.readObject();
        ois.close();

        return secretKey;
    }
}

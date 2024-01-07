package org.blackberry020.encryption.key.writer;

import lombok.AllArgsConstructor;

import javax.crypto.SecretKey;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

@AllArgsConstructor
public class BinaryKeyWriter {
    OutputStream fos;
    public void writeKey(SecretKey secretKey) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(secretKey);
        oos.close();
    }
}

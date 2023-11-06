package org.blackberry020.cipher;

import org.blackberry020.AlgebraicExpression;
import org.blackberry020.read.Reader;
import org.blackberry020.read.ReaderFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;

public class MainCipher {

    private StringEncrypterDecrypter processor;

    public void method() throws Exception {
        String fileName = "archives/zips/inputTxt.zip";

        Reader reader = ReaderFactory.getReader(fileName);
        AlgebraicExpression dop = reader.read(fileName);

        String originalContent = dop.expression;
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        //System.out.println("original " + originalContent);

        StringEncrypterDecrypter fileEncrypterDecrypter
                = new StringEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");

        fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

        String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");

        //System.out.println("dectypted " + decryptedContent);
    }
}

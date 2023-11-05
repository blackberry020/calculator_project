import org.blackberry020.AlgebraicExpression;
import org.blackberry020.cipher.FileEncrypterDecrypter;
import org.blackberry020.read.Reader;
import org.blackberry020.read.ReaderFactory;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CipherTest {

    @Test
    public void whenEncryptingIntoFile_andDecryptingFileAgain_thenOriginalStringIsReturned() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        String originalContent = "some_content\nanother_content\n";
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        //System.out.println(originalContent);

        FileEncrypterDecrypter fileEncrypterDecrypter
                = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");

        fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

        String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");

        //System.out.println(decryptedContent);

        assertThat(decryptedContent, is(originalContent));

        new File("baz.enc").delete(); // cleanup
    }

    @Test
    public void encrypt_decrypt_input() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

        String fileName = "io_files/input.txt";

        Reader reader = ReaderFactory.getReader(fileName);
        AlgebraicExpression dop = reader.read(fileName);

        String originalContent = dop.expression;
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        //System.out.println("original " + originalContent);

        FileEncrypterDecrypter fileEncrypterDecrypter
                = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");

        fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

        String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");

        //System.out.println("dectypted " + decryptedContent);

        assertThat(decryptedContent, is(originalContent));

        new File("baz.enc").delete(); // cleanup
    }
}

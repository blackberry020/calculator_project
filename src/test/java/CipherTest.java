import org.blackberry020.cipher.StringEncrypterDecrypter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CipherTest {

    /*@Test
    public void whenEncryptingIntoFileAndDecryptingFileAgainThenOriginalStringIsReturned() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        String originalContent = "some_content\nanother_content\n";
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        StringEncrypterDecrypter fileEncrypterDecrypter
                = new StringEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");

        fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

        String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");

        assertThat(decryptedContent, is(originalContent));

        new File("baz.enc").delete(); // cleanup
    }

    @Test
    public void encryptsAndDecryptsInputFileDirectory() throws Exception {

        String fileName = "io_files";

        Reader reader = ReaderFactory.getReader(fileName);
        AlgebraicExpression dop = reader.read(fileName);

        String originalContent = dop.expression;
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        StringEncrypterDecrypter fileEncrypterDecrypter
                = new StringEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");

        fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

        String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");

        assertThat(decryptedContent, is(originalContent));

        new File("baz.enc").delete();
    }*/
}

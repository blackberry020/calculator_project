package org.blackberry020.core.config;

import org.blackberry020.app.base64Converter.BaseConverter;
import org.blackberry020.app.base64Converter.BaseConverterImpl;
import org.blackberry020.core.processor.cmd.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static org.blackberry020.app.Transformator.transformation;

@Configuration
public class AppBeansConfiguration {

    @Value("${secret-key.path}")
    private String secretKeyPath;

    @Bean
    public BaseConverter baseConverter() {
        return new BaseConverterImpl();
    }

    @Bean
    public Cipher cipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(transformation);
    }


    @Bean
    public SecretKey loadKey() throws IOException, ClassNotFoundException {
        Resource res = new ClassPathResource(secretKeyPath, this.getClass().getClassLoader());

        return (SecretKey) new ObjectInputStream(res.getInputStream()).readObject();
    }


    @Bean
    public Map<String, ManipulationCommand> commands(Cipher cipher, SecretKey secretKey) {
        return Map.of(
                "DECOMPRESS", new DecompressCommand(),
                "COMPRESS", new CompressCommand(),
                "DECRYPT", new DecryptCommand(cipher, secretKey),
                "ENCRYPT", new EncryptCommand(cipher, secretKey)
        );
    }
}

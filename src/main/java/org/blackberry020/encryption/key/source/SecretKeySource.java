package org.blackberry020.encryption.key.source;

import javax.crypto.SecretKey;

public interface SecretKeySource {
    SecretKey getKey() throws Exception;
}

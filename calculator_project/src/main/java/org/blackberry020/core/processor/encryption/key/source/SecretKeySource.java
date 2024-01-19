package org.blackberry020.core.processor.encryption.key.source;

import javax.crypto.SecretKey;

public interface SecretKeySource {
    SecretKey getKey() throws Exception;
}

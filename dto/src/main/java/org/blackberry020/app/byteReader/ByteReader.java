package org.blackberry020.app.byteReader;

import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    public byte[] read(InputStream is) throws IOException {
        return is.readAllBytes();
    }
}

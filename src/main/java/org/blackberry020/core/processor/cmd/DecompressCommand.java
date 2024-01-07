package org.blackberry020.core.processor.cmd;

import org.blackberry020.core.encryption.entity.CoreEntity;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

public class DecompressCommand implements ManipulationCommand {
    @Override
    public CoreEntity process(CoreEntity entity) throws Exception {

        byte[] data = entity.getData();

        Inflater inflater = new Inflater();
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();

        entity.setData(outputStream.toByteArray());
        return entity;
    }
}

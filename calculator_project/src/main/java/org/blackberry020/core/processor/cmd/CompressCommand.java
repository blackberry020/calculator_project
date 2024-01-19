package org.blackberry020.core.processor.cmd;

import org.blackberry020.core.processor.entity.CoreEntity;

import java.util.zip.Deflater;
import java.io.ByteArrayOutputStream;

public class CompressCommand implements ManipulationCommand {

    @Override
    public CoreEntity process(CoreEntity entity) throws Exception {

        byte[] data = entity.getData();

        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();

        entity.setData(outputStream.toByteArray());
        return entity;
    }
}

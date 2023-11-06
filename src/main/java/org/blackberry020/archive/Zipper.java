package org.blackberry020.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
    public void zip(String source_dir, String zip_file) throws Exception
    {
        FileOutputStream fout = new FileOutputStream(zip_file);
        ZipOutputStream zout = new ZipOutputStream(fout);

        File fileSource = new File(source_dir);

        addDirectory(zout, fileSource);

        zout.close();
    }
    private void addDirectory(ZipOutputStream zout, File fileSource)
            throws Exception
    {

        File[] files;

        if (fileSource.isDirectory())
            files = fileSource.listFiles();
        else files = new File[]{fileSource};

        for(int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()) {
                addDirectory(zout, files[i]);
                continue;
            }

            FileInputStream fis = new FileInputStream(files[i]);

            zout.putNextEntry(new ZipEntry(files[i].getPath()));

            byte[] buffer = new byte[4048];
            int length;
            while((length = fis.read(buffer)) > 0)
                zout.write(buffer, 0, length);

            zout.closeEntry();
            fis.close();
        }
    }
}

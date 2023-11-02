package org.blackberry020.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipArchivator {

    public void zip(String fileNameToArchive, String zipFileName) {

        File zipFile = null;

        try {
            zipFile = new File(zipFileName);
            zipFile.createNewFile();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (
                ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipFile));
                FileInputStream fis = new FileInputStream(fileNameToArchive);
        ) {
            ZipEntry entry1 = new ZipEntry(fileNameToArchive);
            zout.putNextEntry(entry1);

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            zout.write(buffer);

            zout.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void unzip(String zipFileName, String usualFileName) {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry entry;
            String name;

            while((entry = zin.getNextEntry()) != null){
                name = entry.getName();

                FileOutputStream fout = new FileOutputStream(usualFileName);

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

package org.blackberry020.archive;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzipper {

    private final String SLASH_BACK = "/";

    private void createDir(final String dir)
    {
        File file = new File(dir);
        if (!file.exists())
            file.mkdirs();
    }
    private void createFolder(final String dirName)
    {
        if (dirName.endsWith(SLASH_BACK))
            createDir(dirName.substring(0, dirName.length() - 1));
    }
    private void checkFolder(final String file_path)
    {
        if (!file_path.endsWith(SLASH_BACK) && file_path.contains(SLASH_BACK)) {
            String dir = file_path.substring(0, file_path.lastIndexOf(SLASH_BACK));
            createDir(dir);
        }
    }
    public void unzip(final String zipDir) throws Exception
    {
        ZipFile zipFile = new ZipFile(zipDir);
        Enumeration<?> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String entryName = entry.getName();
            if (entryName.endsWith(SLASH_BACK)) {
                createFolder (entryName);
                continue;
            } else
                checkFolder(entryName);
            InputStream fis = (InputStream) zipFile.getInputStream(entry);

            FileOutputStream fos = new FileOutputStream(entryName);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
            fis.close();
            fos.close();
        }
        zipFile.close() ;
    }
}
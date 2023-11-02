package org.blackberry020;

import org.blackberry020.archive.ZipArchivator;

public class Main {

    public static void main(String[] args) throws Exception {

        /*
        String fileName = "io_files/input.txt";

        Reader reader = ReaderFactory.getReader(fileName);
        AlgebraicExpression dop = reader.read(fileName);

        System.out.println(dop.expression);
        */

        String fileName = "io_files/input.txt";
        String zippedInput = "archives/zips/inputTxt.zip";

        ZipArchivator archivator = new ZipArchivator();
        archivator.zip(fileName, zippedInput);
    }
}
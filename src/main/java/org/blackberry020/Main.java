package org.blackberry020;

import org.blackberry020.archive.Unzipper;
import org.blackberry020.archive.Zipper;

public class Main {

    public static void main(String[] args) throws Exception {

        /*
        String fileName = "io_files/input.txt";

        Reader reader = ReaderFactory.getReader(fileName);
        AlgebraicExpression dop = reader.read(fileName);

        System.out.println(dop.expression);
        */

        //Zipper zipper = new Zipper();
        //zipper.zip("io_files", "archives/zips/io_files.zip");

        Unzipper unzipper = new Unzipper();
        try {
            unzipper.unzip("archives/zips/prob1.zip");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
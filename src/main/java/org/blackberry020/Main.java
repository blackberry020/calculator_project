package org.blackberry020;

import javax.xml.bind.JAXBException;

public class Main {
    /*
        mini tasks for the evening:
            import tests
            test file reading functions
            make reading with external libraries
            create an interface for reader
            create 3 classes Readers derived from Reader interface
     */

    public static void main(String[] args) throws Exception {

        String fileName = "io_files/input.txt";

        Reader reader = ReaderFactory.getReader(fileName);
        AlgebraicExpression dop = reader.read(fileName);

        System.out.println(dop.expression);
    }
}
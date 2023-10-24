package org.blackberry020;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {

    /*
        mini tasks for the evening:
            import tests
            test file reading functions
            make reading with external libraries
            create an interface for reader
            create 3 classes Readers derived from Reader interface
     */
    public static void main(String[] args) throws IOException, JAXBException {
        String filePath = "io_files/input.xml";
        String xmldata = Reader.read(filePath);

        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(AlgebraicExpression.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        AlgebraicExpression dop = (AlgebraicExpression) unmarshaller.unmarshal(reader);

        System.out.println(dop.expression);
    }
}
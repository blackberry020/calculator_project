package org.blackberry020;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

public class XmlReader {
    public static AlgebraicExpression read(String filePath) throws IOException, JAXBException {
        String xmldata = Reader.read(filePath);
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(AlgebraicExpression.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (AlgebraicExpression) unmarshaller.unmarshal(reader);
    }
}

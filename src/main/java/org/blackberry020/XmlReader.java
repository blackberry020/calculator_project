package org.blackberry020;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlReader implements Reader {

    @Override
    public AlgebraicExpression read(String filePath) {
        String xmldata = StringReader.read(filePath);
        java.io.StringReader reader = new java.io.StringReader(xmldata);

        AlgebraicExpression result = new AlgebraicExpression();

        try {
            JAXBContext context = JAXBContext.newInstance(AlgebraicExpression.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            result = (AlgebraicExpression) unmarshaller.unmarshal(reader);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}

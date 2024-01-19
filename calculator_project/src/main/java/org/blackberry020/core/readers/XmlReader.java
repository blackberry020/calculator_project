package org.blackberry020.core.readers;

import org.blackberry020.core.AlgebraicExpression;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlReader implements Reader {

    @Override
    public AlgebraicExpression read(String xmlData) throws Exception {
        java.io.StringReader reader = new java.io.StringReader(xmlData);

        JAXBContext context = JAXBContext.newInstance(AlgebraicExpression.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (AlgebraicExpression) unmarshaller.unmarshal(reader);
    }
}

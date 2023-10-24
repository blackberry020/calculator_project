package org.blackberry020;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AlgebraicExpression")
@XmlRootElement
public class AlgebraicExpression {

    public String expression;

    AlgebraicExpression(String exp) {
        this.expression = exp;
    }

    AlgebraicExpression() {
        this.expression = "";
    }
}

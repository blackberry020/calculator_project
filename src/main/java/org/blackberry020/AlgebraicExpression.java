package org.blackberry020;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AlgebraicExpression")
@XmlRootElement
public class AlgebraicExpression {

    public String expression;

    public AlgebraicExpression(String exp) {
        this.expression = exp;
    }

    public AlgebraicExpression() {
        this.expression = "";
    }
}

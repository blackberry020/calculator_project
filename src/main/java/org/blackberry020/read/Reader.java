package org.blackberry020.read;

import org.blackberry020.AlgebraicExpression;

public interface Reader {
    abstract public AlgebraicExpression read(String fileName);
}

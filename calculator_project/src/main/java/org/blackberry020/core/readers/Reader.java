package org.blackberry020.core.readers;

import org.blackberry020.core.AlgebraicExpression;

public interface Reader {
    abstract public AlgebraicExpression read(String fileName) throws Exception;
}

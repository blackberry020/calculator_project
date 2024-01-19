package org.blackberry020.core.readers;

import org.blackberry020.core.AlgebraicExpression;

public class TxtReader implements Reader {

    @Override
    public AlgebraicExpression read(String content) throws Exception {
        AlgebraicExpression result = new AlgebraicExpression();
        result.expression = content;
        return result;
    }
}

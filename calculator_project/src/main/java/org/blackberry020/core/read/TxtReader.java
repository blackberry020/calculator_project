package org.blackberry020.core.read;

import org.blackberry020.core.AlgebraicExpression;

public class TxtReader implements Reader {

    @Override
    public AlgebraicExpression read(String filePath) {
        AlgebraicExpression result = new AlgebraicExpression();
        result.expression = StringReader.read(filePath);
        return result;
    }
}

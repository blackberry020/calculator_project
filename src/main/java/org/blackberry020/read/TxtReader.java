package org.blackberry020.read;

import org.blackberry020.AlgebraicExpression;

public class TxtReader implements Reader {

    @Override
    public AlgebraicExpression read(String filePath) {
        AlgebraicExpression result = new AlgebraicExpression();
        result.expression = StringReader.read(filePath);
        return result;
    }
}

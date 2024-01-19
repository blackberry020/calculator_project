package org.blackberry020.core.readers;

import com.google.gson.Gson;
import org.blackberry020.core.AlgebraicExpression;

public class JsonReader implements Reader {

    private static class ExpressionContainer {
        AlgebraicExpression AlgebraicExpression;
    }

    @Override
    public AlgebraicExpression read(String content) throws Exception {
        Gson gson = new Gson();
        ExpressionContainer data = gson.fromJson(content, ExpressionContainer.class);
        return data.AlgebraicExpression;
    }
}

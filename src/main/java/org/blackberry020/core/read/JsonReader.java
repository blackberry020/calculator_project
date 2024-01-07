package org.blackberry020.core.read;

import org.blackberry020.core.AlgebraicExpression;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader implements Reader {

    @Override
    public AlgebraicExpression read(String fileName) {
        JSONParser jsonParser = new JSONParser();
        Object obj;
        AlgebraicExpression result = null;

        try (FileReader reader = new FileReader(fileName))
        {
            obj = jsonParser.parse(reader);
            result = parseExpressionObject((JSONObject)obj);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    private static AlgebraicExpression parseExpressionObject(JSONObject exp)
    {
        JSONObject expObject = (JSONObject) exp.get("AlgebraicExpression");
        String finalExpression = (String) expObject.get("expression");
        return new AlgebraicExpression(finalExpression);
    }
}

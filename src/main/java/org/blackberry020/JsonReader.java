package org.blackberry020;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReader implements Reader {

    @Override
    public AlgebraicExpression read(String fileName) {
        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        AlgebraicExpression result = null;

        try (FileReader reader = new FileReader(fileName))
        {
            obj = jsonParser.parse(reader);
            result = parseExpressionObject((JSONObject)obj);
        }
        catch (Exception e) {
            e.printStackTrace();
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

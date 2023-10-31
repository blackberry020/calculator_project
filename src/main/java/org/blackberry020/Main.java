package org.blackberry020;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    /*
        mini tasks for the evening:
            import tests
            test file reading functions
            make reading with external libraries
            create an interface for reader
            create 3 classes Readers derived from Reader interface
     */

    public static void main(String[] args) {

        String fileName = "io_files/input.json";

        AlgebraicExpression dop = JsonReader.read(fileName);

        System.out.println(dop.expression);
    }
}
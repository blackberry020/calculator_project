package org.blackberry020;

import org.blackberry020.archive.Unzipper;
import org.blackberry020.archive.Zipper;
import org.blackberry020.evaluation.Calculator;
import org.blackberry020.evaluation.CustomCalculator;
import org.blackberry020.read.Reader;
import org.blackberry020.read.ReaderFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println("Enter the name of file that contains an algebraic expression");
        //String fileName = consoleReader.readLine();
        String fileName = "io_files/input.txt";

        if (!fileName.matches("^[^\\.]+\\.((txt)|(xml)|(json))$")) {
            System.out.println("Wrong file name. It should have txt, xml or json extension");
        }
        else {
            Reader reader = ReaderFactory.getReader(fileName);
            AlgebraicExpression exp = reader.read(fileName);

            System.out.print("The result is ");
            System.out.println(Calculator.calculate(exp));

            CustomCalculator calculator = new CustomCalculator();
            calculator.convertToPolishNotation(exp.expression);
        }
    }
}
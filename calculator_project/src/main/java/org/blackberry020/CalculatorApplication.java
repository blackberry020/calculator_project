package org.blackberry020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    /*public static void main(String[] args) throws Exception {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the name of file that contains an algebraic expression");
        String fileName = consoleReader.readLine();
        //String fileName = "io_files/input.txt";

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
    }*/
}
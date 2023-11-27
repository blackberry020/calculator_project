package org.blackberry020.evaluation;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomCalculator {

    private final Map<String, Integer> operators = Map.of(
            "(", 1,
            ")", 1,
            "*", 2,
            "/", 2,
            "+",3,
            "-", 3
    );

    private final
    Pattern expressionPartPattern = Pattern.compile("(\\d+\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)])");

    private Stack<String> operationsStack;
    private ArrayList<String> polishNotation;

    public CustomCalculator() {
        operationsStack = new Stack<>();
        polishNotation = new ArrayList<>();
    }

    public void convertToPolishNotation(String expression) {
        expression = expression.replaceAll(" ", "");
        Matcher partMatcher = expressionPartPattern.matcher(expression);

        while (partMatcher.find()) {

            String curPart = partMatcher.group();

            if (isOperator(curPart)) {
                if (!operationsStack.empty()) {
                    if (operators.get(operationsStack.peek()) <= operators.get(curPart)) {
                        String prevOperator = operationsStack.pop();
                        polishNotation.add(prevOperator);
                    }
                }
                operationsStack.push(curPart);
            }
            else {
                polishNotation.add(curPart);
            }

            System.out.println("stack is " + operationsStack);
            System.out.println("output is " + polishNotation + '\n');
        }

        while (!operationsStack.empty()) {
            polishNotation.add(operationsStack.pop());
        }

        System.out.println("stack is " + operationsStack);
        System.out.println("output is " + polishNotation + '\n');
    }

    private boolean isOperator(String str) {
        return operators.containsKey(str);
    }
}
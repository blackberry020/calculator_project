package org.blackberry020.evaluation;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.blackberry020.AlgebraicExpression;

public class Calculator {

    public static Double calculate(AlgebraicExpression exp) {

        DoubleEvaluator evaluator = new DoubleEvaluator();

        return evaluator.evaluate(exp.expression);
    }
}

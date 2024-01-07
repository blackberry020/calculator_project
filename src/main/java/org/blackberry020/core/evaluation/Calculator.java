package org.blackberry020.core.evaluation;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.blackberry020.core.AlgebraicExpression;

public class Calculator {

    public static Double calculate(AlgebraicExpression exp) {

        DoubleEvaluator evaluator = new DoubleEvaluator();

        return evaluator.evaluate(exp.expression);
    }
}

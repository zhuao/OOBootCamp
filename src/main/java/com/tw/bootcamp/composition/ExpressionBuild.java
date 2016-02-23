package com.tw.bootcamp.composition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionBuild {
    private String expression;

    public ExpressionBuild(String expression) {
        this.expression = expression.replaceAll(" ", "");;
    }

    public ArithmeticExpression build() {
        return build(expression);
    }

    private ArithmeticExpression build(String expression) {
        if (expression.charAt(0) == '(') {
            return build(expression.substring(1, expression.length() - 1));
        } else {

            Pattern pattern = Pattern.compile("[^1-9]+");
            Matcher matcher = pattern.matcher(expression);

            if (matcher.find()) {

                int position = matcher.start();
                char symbol = expression.charAt(position);
                switch (symbol) {
                    case '+':
                        return new Plus(build(expression.substring(0, position)), build(expression.substring(position + 1, expression.length())));
                    case '-':
                        return new Minus(build(expression.substring(0, position)), build(expression.substring(position + 1, expression.length())));
                    case '*':
                        return new Multiply(build(expression.substring(0, position)), build(expression.substring(position + 1, expression.length())));
                    default:
                        throw new RuntimeException("the symbol " + symbol + " is invalidate!");
                }

            } else {
                return new Value(expression);
            }

        }
    }
}

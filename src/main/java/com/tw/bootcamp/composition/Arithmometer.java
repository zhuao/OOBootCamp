package com.tw.bootcamp.composition;

import java.math.BigDecimal;

public class Arithmometer {


    private ExpressionBuild expressionBuild;
    private String expression;

    public void input(String expression) {
        this.expression = expression.replaceAll(" ", "");
        expressionBuild = new ExpressionBuild(this.expression);
    }

    public BigDecimal result() {

        ArithmeticExpression expression = expressionBuild.build();
        return expression.calculate();


    }
}

package com.tw.bootcamp.composition;

import java.math.BigDecimal;

public class Multiply implements ArithmeticExpression {
    private ArithmeticExpression multiplicand;
    private ArithmeticExpression number;

    public Multiply(ArithmeticExpression build, ArithmeticExpression multiplicand) {
        this.number = build;
        this.multiplicand = multiplicand;
    }

    @Override
    public BigDecimal calculate() {
        return number.calculate().multiply(multiplicand.calculate());
    }
}

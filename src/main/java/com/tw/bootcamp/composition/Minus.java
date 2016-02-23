package com.tw.bootcamp.composition;

import java.math.BigDecimal;

public class Minus implements ArithmeticExpression {

    private ArithmeticExpression minuend;
    private ArithmeticExpression subtrahend;

    public Minus(ArithmeticExpression minuend, ArithmeticExpression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public BigDecimal calculate() {
        return minuend.calculate().subtract(subtrahend.calculate());
    }
}

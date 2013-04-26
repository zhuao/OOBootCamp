package com.tw.bootcamp.composition;

import java.math.BigDecimal;

public class Value implements ArithmeticExpression {
    private Double value;

    public Value(String expression) {
        this.value = Double.valueOf(expression);
    }

    @Override
    public BigDecimal calculate() {
        return BigDecimal.valueOf(value);
    }
}

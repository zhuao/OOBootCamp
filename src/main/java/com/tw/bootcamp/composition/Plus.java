package com.tw.bootcamp.composition;

import java.math.BigDecimal;

public class Plus implements ArithmeticExpression {
    private ArithmeticExpression addend;
    private ArithmeticExpression augend;

    public Plus(ArithmeticExpression addend, ArithmeticExpression augend) {
        this.addend = addend;
        this.augend = augend;
    }

    @Override
    public BigDecimal calculate() {
        return addend.calculate().add(augend.calculate());
    }
}

package com.tw.bootcamp.saletax;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CalculatedNumber {
    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private BigDecimal number;

    public CalculatedNumber(BigDecimal number) {
        this.number = number;
    }

    public CalculatedNumber() {
        this.number = BigDecimal.valueOf(0);
    }

    public CalculatedNumber(CalculatedNumber number) {
        this.number = number.getNumber();
    }

    public CalculatedNumber roundUp() {
        int param = number.multiply(BigDecimal.valueOf(100)).intValue();
        int lastNumber = param % 10;
        int divideNumber = param / 10;
        if (lastNumber > 5) {
            lastNumber = 10;
        } else if (lastNumber > 0) {
            lastNumber = 5;
        }
        number = BigDecimal.valueOf(divideNumber * 10 + lastNumber).divide(BigDecimal.valueOf(100));
        return this;
    }

    public CalculatedNumber multiply(double v) {
        number = number.multiply(BigDecimal.valueOf(v));
        return this;
    }

    public CalculatedNumber add(CalculatedNumber addNumber) {
        number = number.add(addNumber.getNumber());
        return this;
    }

    @Override
    public String toString() {
        return decimalFormat.format(number);
    }

    private BigDecimal getNumber() {
        return number;
    }
}

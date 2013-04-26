package com.tw.bootcamp.saletax;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CalculatedNumber {
    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private BigDecimal price;

    public CalculatedNumber(BigDecimal price) {
        this.price = price;
    }

    public CalculatedNumber() {
        this.price = BigDecimal.valueOf(0);
    }

    public CalculatedNumber(CalculatedNumber price) {
        this.price = price.getNumber();
    }

    public CalculatedNumber roundUp() {
        int param = price.multiply(BigDecimal.valueOf(100)).intValue();
        int lastNumber = param % 10;
        int divideNumber = param / 10;
        if (lastNumber > 5) {
            lastNumber = 10;
        } else if (lastNumber > 0) {
            lastNumber = 5;
        }
        price = BigDecimal.valueOf(divideNumber * 10 + lastNumber).divide(BigDecimal.valueOf(100));
        return this;
    }

    public CalculatedNumber multiply(double v) {
        price = price.multiply(BigDecimal.valueOf(v));
        return this;
    }

    public CalculatedNumber add(CalculatedNumber addNumber) {
        price = price.add(addNumber.getNumber());
        return this;
    }

    @Override
    public String toString() {
        return decimalFormat.format(price);
    }

    private BigDecimal getNumber() {
        return price;
    }
}

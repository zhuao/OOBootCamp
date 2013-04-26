package com.tw.bootcamp.saletax;

import java.math.BigDecimal;

public class Price {

    private BigDecimal price;

    public Price(BigDecimal price) {
        this.price = price;
    }

    public Price(int i) {
        price = BigDecimal.valueOf(i);
    }

    public Price(Price price) {
        this.price = price.getNumber();
    }

    public Price roundUp() {
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

    public Price multiply(int bigDecimal) {
        price = price.multiply(BigDecimal.valueOf(bigDecimal));
        return this;
    }

    public Price multiply(double v) {
        price = price.multiply(BigDecimal.valueOf(v));
        return this;
    }

    public Price add(Price addNumber) {
        price = price.add(addNumber.getNumber());
        return this;
    }

    @Override
    public String toString() {
        return price.toString();
    }

    private BigDecimal getNumber() {
        return price;
    }
}

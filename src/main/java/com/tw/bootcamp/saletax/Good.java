package com.tw.bootcamp.saletax;

import java.math.BigDecimal;

public class Good {
    private final String name;
    private final CalculatedNumber price;
    private final int quantity;

    public Good(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = new CalculatedNumber(price);
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public CalculatedNumber getPrice() {
        return new CalculatedNumber(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public CalculatedNumber getQuote() {
        return new CalculatedNumber(price).multiply(quantity);
    }
}

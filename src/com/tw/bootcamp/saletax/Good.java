package com.tw.bootcamp.saletax;

import java.math.BigDecimal;

public class Good {
    private final String name;
    private final Price price;
    private final int quantity;

    public Good(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = new Price(price);
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return new Price(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public Price getQuote() {
        return new Price(price).multiply(quantity);
    }
}

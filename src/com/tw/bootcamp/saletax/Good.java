package com.tw.bootcamp.saletax;

import java.math.BigDecimal;

public class Good {
    private final String name;
    private final BigDecimal price;
    private final int quantity;

    public Good(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getQuote() {
        return price.multiply(new BigDecimal(quantity)) ;
    }
}

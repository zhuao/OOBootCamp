package com.tw.bootcamp.pricecalculator;

public class CashRegister {
    public float charge(String productItem) {
        if ("C".equals(productItem)) {
            return 10;
        }
        if ("B".equals(productItem)) {
            return 30;
        }
        return 50;
    }
}

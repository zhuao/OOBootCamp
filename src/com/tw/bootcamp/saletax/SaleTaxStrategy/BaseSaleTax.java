package com.tw.bootcamp.saletax.SaleTaxStrategy;

public class BaseSaleTax implements SaleTaxStrategy {

    private float BASE_SALE_TAX_RATE = 0.1f;

    @Override
    public float getSaleTax(float amount) {
        return amount * BASE_SALE_TAX_RATE;
    }
}

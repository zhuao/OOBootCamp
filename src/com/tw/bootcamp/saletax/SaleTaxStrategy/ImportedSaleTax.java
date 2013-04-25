package com.tw.bootcamp.saletax.SaleTaxStrategy;

public class ImportedSaleTax implements SaleTaxStrategy {

    private float IMPORTED_SALE_TAX_RATE = 0.05f;

    @Override
    public float getSaleTax(float amount) {
        return amount * IMPORTED_SALE_TAX_RATE;
    }
}

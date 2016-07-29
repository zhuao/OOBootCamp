package com.tw.bootcamp.pricecalculator;

import java.util.HashMap;

public class PriceCalculator {

    private HashMap<String, Float> priceTable;

    public PriceCalculator(HashMap<String, Float> priceTable) {
        this.priceTable = priceTable;
    }

    public float calculate(String shoppingList) {
        String[] productList = toProductList(shoppingList);
        float priceAmount = 0;
        for (String product : productList) {
            priceAmount += findProductPrice(String.valueOf(product));
        }
        return priceAmount;
    }

    private float findProductPrice(String product) {
        Float price = priceTable.get(product);
        return  price == null ? 0 : price;
    }

    private String[] toProductList(String shoppingList) {
        return shoppingList.split("");
    }
}

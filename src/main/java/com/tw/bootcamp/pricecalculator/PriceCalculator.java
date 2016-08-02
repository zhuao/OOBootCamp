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

        int productACount = countProduct(productList, "A");
        int productBCount = countProduct(productList, "B");

        return priceAmount - 20 * (productACount / 3) - 10 * (productBCount /2);
    }

    private int countProduct(String[] productList, String product) {
        int count = 0;
        for (String productItem : productList) {
            if (productItem.equals(product)) {
                count++;
            }
        }
        return count;
    }

    private float findProductPrice(String product) {
        Float price = priceTable.get(product);
        return  price == null ? 0 : price;
    }

    private String[] toProductList(String shoppingList) {
        return shoppingList.split("");
    }


}

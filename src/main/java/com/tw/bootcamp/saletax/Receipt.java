package com.tw.bootcamp.saletax;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Receipt {
    private List<Good> goods = new LinkedList<Good>();

    public void addGood(String input) {
        String[] goodInfo = input.split(" ");

        String goodName = goodInfo[1];
        for (int index = 2; index < goodInfo.length - 2; index++) {
            goodName += " " + goodInfo[index];
        }

        goods.add(new Good(goodName, new BigDecimal(goodInfo[goodInfo.length - 1]), Integer.valueOf(goodInfo[0])));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Good good : goods) {
            stringBuilder.append(good.getQuantity())
                    .append(" ")
                    .append(good.getName())
                    .append(": ")
                    .append(calculateSaleTax(good).roundUp().add(good.getQuote()))
                    .append("\n");
        }

        stringBuilder.append("Sales Taxes: ").append(calculateSaleTax().roundUp()).append("\n");
        stringBuilder.append("Total: ").append(calculateSaleTax().roundUp().add(getQuota()));
        return stringBuilder.toString();
    }

    private CalculatedNumber calculateSaleTax(Good good) {
        CalculatedNumber tax = new CalculatedNumber();

        if (good.getName().contains("imported")) {
            tax.add(good.getQuote().multiply(0.05));
        }

        if (!good.getName().contains("book") && !good.getName().contains("chocolate") && !good.getName().contains("headache")) {
            tax.add(good.getQuote().multiply(0.1));
        }
        return tax;
    }

    private CalculatedNumber getQuota() {
        CalculatedNumber count = new CalculatedNumber();
        for (Good good : goods) {
            count.add(good.getQuote());
        }
        return count;
    }

    private CalculatedNumber calculateSaleTax() {
        CalculatedNumber saleTax = new CalculatedNumber();
        for (Good good : goods) {
            saleTax = saleTax.add(calculateSaleTax(good));
        }
        return saleTax;
    }

}

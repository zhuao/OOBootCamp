package com.tw.bootcamp.saletax;

import javax.xml.crypto.dsig.dom.DOMValidateContext;
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
        stringBuilder.append("Total: ").append(getQuota().add(calculateSaleTax().roundUp()));
        return stringBuilder.toString();
    }


    private Price calculateSaleTax(Good good) {
        Price tax = new Price(0);

        if (good.getName().contains("imported")) {
            tax = tax.add(good.getQuote().multiply(0.05));
        }

        if (!good.getName().contains("book") && !good.getName().contains("chocolate") && !good.getName().contains("headache")) {
            tax = tax.add(good.getQuote().multiply(0.1));
        }
        return tax;
    }

    private Price getQuota() {
        Price count = new Price(0);
        for (Good good : goods) {
            count = count.add(good.getQuote());
        }
        return count;
    }

    private Price calculateSaleTax() {
        Price saleTax = new Price(0);
        for (Good good : goods) {
            saleTax = saleTax.add(calculateSaleTax(good));
        }
        return saleTax;
    }

}

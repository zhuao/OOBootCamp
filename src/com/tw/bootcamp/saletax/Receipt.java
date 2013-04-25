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
                    .append(roundUp(calculateSaleTax(good)).add(good.getQuote()))
                    .append("\n");
        }

        stringBuilder.append("Sales Taxes: ").append(roundUp(calculateSaleTax())).append("\n");
        stringBuilder.append("Total: ").append(getQuota().add(roundUp(calculateSaleTax())));
        return stringBuilder.toString();
    }

    private BigDecimal roundUp(BigDecimal bigDecimal) {
        BigDecimal multiply = bigDecimal.multiply(BigDecimal.valueOf(100));
        int param = multiply.intValue();
        int lastNumber = param % 10;
        int divideNumber = param / 10;
        if (lastNumber > 5) {
            lastNumber = 10;
        } else if (lastNumber > 0) {
            lastNumber = 5;
        }
        return BigDecimal.valueOf((divideNumber * 10 + lastNumber)).divide(BigDecimal.valueOf(100));
    }

    private BigDecimal calculateSaleTax(Good good) {
        BigDecimal tax = new BigDecimal(0);

        if (good.getName().contains("imported")) {
            tax = tax.add(good.getQuote().multiply(new BigDecimal(0.05)));
        }

        if (!good.getName().contains("book") && !good.getName().contains("chocolate") && !good.getName().contains("headache")) {
            tax = tax.add(good.getQuote().multiply(new BigDecimal(0.1)));
        }
        return tax;
    }

    private BigDecimal getQuota() {
        BigDecimal count = new BigDecimal(0);
        for (Good good : goods) {
            count = count.add(good.getQuote());
        }
        return count;
    }

    private BigDecimal calculateSaleTax() {
        BigDecimal saleTax = new BigDecimal(0);
        for (Good good : goods) {
            saleTax = saleTax.add(calculateSaleTax(good));
        }
        return saleTax;
    }

    private float roundUp(float result) {
        int param = ((Float) (result * 100)).intValue();
        int lastNumber = param % 10;
        int divideNumber = param / 10;
        if (lastNumber > 5) {
            lastNumber = 10;
        } else if (lastNumber > 0) {
            lastNumber = 5;
        }
        return (divideNumber * 10 + lastNumber) / 100f;
    }
}

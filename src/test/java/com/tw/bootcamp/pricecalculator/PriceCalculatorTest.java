package com.tw.bootcamp.pricecalculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PriceCalculatorTest {

    private HashMap<String, Float> priceTable;
    private PriceCalculator calculator;


    @Before
    public void setUp() {
        priceTable = new HashMap<>();
        priceTable.put("A", 50f);
        priceTable.put("B", 30f);
        priceTable.put("C", 10f);

        calculator = new PriceCalculator(priceTable);

    }

    @Test
    public void should_get_product_A_price() {
        assertThat(calculator.calculate("A"), is(50f));
    }

    @Test
    public void should_get_product_B_price() {
        assertThat(calculator.calculate("B"), is(30f));
    }

    @Test
    public void should_get_product_D_price_which_is_not_existed() {
        assertThat(calculator.calculate("D"), is(0f));
    }

    @Test
    public void should_get_right_price_when_purchase_multiple_product() {
        assertThat(calculator.calculate("AB"), is(80f));
    }
}

package com.tw.bootcamp.pricecalculator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CashRegisterTest {

    @Test
    public void should_charge_50_when_purchase_product_A() {
        CashRegister cashRegister = new CashRegister();
        assertThat(cashRegister.charge("A"), is(50f));
    }

    @Test
    public void should_charge_30_when_purchase_product_B() {
        CashRegister cashRegister = new CashRegister();
        assertThat(cashRegister.charge("B"), is(30f));
    }

    @Test
    public void should_charge_10_when_purchase_product_C() {
        CashRegister cashRegister = new CashRegister();
        assertThat(cashRegister.charge("C"), is(10f));
    }

    @Test
    public void should_charge_0_when_purchase_unexisited_product_D() {
        CashRegister cashRegister = new CashRegister();
        assertThat(cashRegister.charge("D"), is(0f));
    }
}

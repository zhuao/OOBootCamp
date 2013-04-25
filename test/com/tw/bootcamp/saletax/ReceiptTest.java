package com.tw.bootcamp.saletax;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReceiptTest {

    private Receipt receipt;

    @Before
    public void setUp() {
        receipt = new Receipt();
    }

    @Test
    public void should_print_good_list_with_good_name_quantity_and_price_when_there_are_three_goods_with_base_tax_rate() {
        receipt.addGood("1 book at 12.49");
        receipt.addGood("1 music CD at 14.99");
        receipt.addGood("1 chocolate bar at 0.85");
        assertThat(receipt.print(), is("1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.5\n" +
//                "Sales Taxes: 1.50\n" +
                "Total: 29.83"));
    }

    @Test
    public void should_print_good_list_with_good_name_quantity_and_price_when_there_are_two_goods_with_imported_tax_rate() {
        receipt.addGood("1 imported box of chocolates at 10.00");
        receipt.addGood("1 imported bottle of perfume at 47.50");
        assertThat(receipt.print(), is("1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15"));
    }

    @Test
    public void should_print_good_list_with_good_name_quantity_and_price_when_there_are_three_goods_with_imported_tax_rate_and_basic_tax_rate() {
        receipt.addGood("1 imported bottle of perfume at 27.99");
        receipt.addGood("1 bottle of perfume at 18.99");
        receipt.addGood("1 packet of headache pills at 9.75");
        receipt.addGood("1 box of imported chocolates at 11.25");
        assertThat(receipt.print(), is("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 box of imported chocolates: 11.85\n" +
                "Sales Taxes: 6.7\n" +
                "Total: 74.68"));
    }
}

package com.tw.bootcamp.composition;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArithmometerTestCase {

    private Arithmometer arithmometer;

    @Before
    public void setUp() {
        this.arithmometer = new Arithmometer();
    }

    @Test
    public void should_return_3_when_input_1_plus_2() {
        arithmometer.input("1+2");

        assertThat(arithmometer.result(), is(BigDecimal.valueOf(3.0)));
    }

    @Test
    public void should_return_4_when_input_2_plus_2() {
        arithmometer.input("2+2");

        assertThat(arithmometer.result(), is(BigDecimal.valueOf(4.0)));
    }

    @Test
    public void should_return_1_when_input_2_minus_1() {
        arithmometer.input("2-1");

        assertThat(arithmometer.result(), is(BigDecimal.valueOf(1.0)));
    }
}

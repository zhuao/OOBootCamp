package com.tw.bootcamp.strategy;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelTest {

    private Hotel hotel;
    private SimpleDateFormat dataGenerator = new SimpleDateFormat("yyyy mm dd");


    @Before
    public void setUp() {
        hotel = new Hotel(159, 0.7);
    }

    @Test
    public void should_no_discount_if_that_day_is_busy() throws ParseException {
        hotel.checkin(false, dataGenerator.parse("2014 07 05"), dataGenerator.parse("2014 07 06"));

        assertThat(hotel.calculate(), is(159d * 2));
    }

    @Test
    public void should_no_discount_for_vip_if_that_day_is_busy() throws ParseException {
        hotel.checkin(true, dataGenerator.parse("2014 07 05"), dataGenerator.parse("2014 07 06"));

        assertThat(hotel.calculate(), is(159d * 2));
    }

    @Test
    public void should_has_discount_if_that_day_is_not_busy() throws ParseException {
        hotel.checkin(false, dataGenerator.parse("2014 07 07"), dataGenerator.parse("2014 07 08"));

        assertThat(hotel.calculate(), is(159d * 2 - 30));
    }

    @Test
    public void should_has_discount_for_vip_if_that_day_is_not_busy() throws ParseException {
        hotel.checkin(true, dataGenerator.parse("2014 07 07"), dataGenerator.parse("2014 07 08"));

        assertThat(hotel.calculate(), is(159d * 2 * 0.7));
    }
}

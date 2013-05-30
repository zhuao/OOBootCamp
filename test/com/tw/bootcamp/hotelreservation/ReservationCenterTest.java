package com.tw.bootcamp.hotelreservation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReservationCenterTest {

    @Test
    public void should_select_lakewood_when_there_are_three_weekdays() {
        ReservationCenter reservationCenter = new ReservationCenter();
        String checkInfo = "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";

        String hotelName = reservationCenter.reserve(checkInfo);

        assertThat(hotelName, is("Lakewood"));
    }

    @Test
    public void should_select_lakewood_when_there_are_a_weekday_and_two_weekend_days() {
        ReservationCenter reservationCenter = new ReservationCenter();
        String checkInfo = "Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)";

        String hotelName = reservationCenter.reserve(checkInfo);

        assertThat(hotelName, is("Bridgewood"));
    }
}

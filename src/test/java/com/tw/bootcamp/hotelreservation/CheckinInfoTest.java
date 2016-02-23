package com.tw.bootcamp.hotelreservation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckinInfoTest {

    @Test
    public void should_return_1_weekday_when_checkin_info_is_2014_3_28() {
        CheckinInfo checkinInfo = new CheckinInfo("Regular: 28Mar2014(mon)");

        assertThat(checkinInfo.getWeekDays(), is(1));
    }
}

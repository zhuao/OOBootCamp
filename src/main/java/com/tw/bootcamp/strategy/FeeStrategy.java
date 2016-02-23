package com.tw.bootcamp.strategy;

import java.util.Calendar;
import java.util.Date;

public class FeeStrategy {

    public double fee(Hotel hotel, boolean isVip, Date[] checkInDates) {
        int days = checkInDates.length;
        boolean isBusy = getWeekendDays(checkInDates) > 0;

        if (isBusy) {
            return hotel.getPricePerDay() * days;
        } else {
            if (isVip) {
                return hotel.getPricePerDay() * days * hotel.getDiscountForVIP();
            } else {
                return (hotel.getPricePerDay() * days) - Double.valueOf(hotel.getPricePerDay() * days).intValue()/100 * 10;
            }
        }
    }

    private int getWeekendDays(Date... checkinDays) {
        int count = 0;
        Calendar instance = Calendar.getInstance();
        for (Date orderedDay : checkinDays) {
            instance.setTime(orderedDay);
            int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);
            if (1 == dayOfWeek || dayOfWeek == 7) {
                count ++;
            }
        }
        return count;
    }

}

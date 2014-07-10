package com.tw.bootcamp.strategy;

import java.util.Calendar;
import java.util.Date;

public class Hotel {

    private double pricePerDay;
    private double discountForVIP;

    public Hotel(double pricePerDay, double discountForVIP) {
        this.pricePerDay = pricePerDay;
        this.discountForVIP = discountForVIP;
    }


    public double fee(boolean isVip, Date[] checkInDates) {
        int days = checkInDates.length;
        boolean isBusy = getWeekendDays(checkInDates) > 0;

        if (isBusy) {
            return pricePerDay * days;
        } else {
            if (isVip) {
                return pricePerDay * days * discountForVIP;
            } else {
                return (pricePerDay * days) - Double.valueOf(pricePerDay * days).intValue()/100 * 10;
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

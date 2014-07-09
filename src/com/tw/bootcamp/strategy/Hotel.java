package com.tw.bootcamp.strategy;

import java.util.Calendar;
import java.util.Date;

public class Hotel {

    private double pricePerDay;
    private int days;
    private double discountForVIP;
    private boolean isBusy;
    private boolean isVip;

    public Hotel(double pricePerDay, double discountForVIP) {
        this.pricePerDay = pricePerDay;
        this.discountForVIP = discountForVIP;
    }


    public double calculate() {
        if (isBusy()) {
            return pricePerDay * days;
        } else {
            if (isVip()) {
                return pricePerDay * days * discountForVIP;
            } else {
                return (pricePerDay * days) - Double.valueOf(pricePerDay * days).intValue()/100 * 10;
            }
        }
    }

    public void checkin(boolean isVip, Date... checkinDays) {
        days = checkinDays.length;
        isBusy = getWeekendDays(checkinDays) > 0;
        this.isVip = isVip;
    }

    private boolean isVip() {
        return isVip;
    }

    private boolean isBusy() {
        return isBusy;
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

package com.tw.bootcamp.strategy;

import java.util.Calendar;
import java.util.Date;

public class Hotel {

    private double pricePerDay;

    public double getDiscountForVIP() {
        return discountForVIP;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    private double discountForVIP;

    public Hotel(double pricePerDay, double discountForVIP) {
        this.pricePerDay = pricePerDay;
        this.discountForVIP = discountForVIP;
    }


    public double fee(boolean isVip, Date[] checkInDates) {
        return new FeeStrategy().fee(this, isVip, checkInDates);
    }

}

package com.tw.bootcamp.hotelreservation;

public class LakewoodHotel implements Hotel {
    @Override
    public float calculatePay(CheckinInfo checkinInfo) {
        if (checkinInfo.isRewardsCustomer()) {
            return checkinInfo.getWeekDays() * 80 + checkinInfo.getWeekendDays() * 80;
        } else {
            return checkinInfo.getWeekDays() * 110 + checkinInfo.getWeekendDays() * 90;
        }
    }

    @Override
    public String getName() {
        return "Lakewood";
    }
}

package com.tw.bootcamp.hotelreservation;

public class RidgewoodHotel implements Hotel {
    @Override
    public float calculatePay(CheckinInfo checkinInfo) {
        if (checkinInfo.isRewardsCustomer()) {
            return checkinInfo.getWeekDays() * 100 + checkinInfo.getWeekendDays() * 40;
        } else {
            return checkinInfo.getWeekDays() * 220 + checkinInfo.getWeekendDays() * 150;
        }
    }

    @Override
    public String getName() {
        return "Ridgewood";
    }
}

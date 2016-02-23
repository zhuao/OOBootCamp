package com.tw.bootcamp.hotelreservation;

public class BridgewoodHotel implements Hotel {
    @Override
    public float calculatePay(CheckinInfo checkinInfo) {
        if (checkinInfo.isRewardsCustomer()) {
            return checkinInfo.getWeekDays() * 110 + checkinInfo.getWeekendDays() * 50;
        } else {
            return checkinInfo.getWeekDays() * 160 + checkinInfo.getWeekendDays() * 60;
        }
    }

    @Override
    public String getName() {
        return "Bridgewood";
    }
}

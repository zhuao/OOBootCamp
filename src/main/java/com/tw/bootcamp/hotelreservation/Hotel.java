package com.tw.bootcamp.hotelreservation;

public interface Hotel {
    float calculatePay(CheckinInfo checkinInfo);

    String getName();
}

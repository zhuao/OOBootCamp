package com.tw.bootcamp.hotelreservation;

import java.util.LinkedList;
import java.util.List;

public class HotelReservation {
    private List<Hotel> hotels = new LinkedList<Hotel>();

    public String reserve(CheckinInfo checkinInfo) {
        return getCheapestHotel(checkinInfo).getName();
    }

    private Hotel getCheapestHotel(CheckinInfo checkinInfo) {

        Hotel cheapestHotel = null;
        float cheapestPay = 999999;
        for (Hotel hotel : hotels) {
            if (hotel.calculatePay(checkinInfo) < cheapestPay) {
                cheapestPay = hotel.calculatePay(checkinInfo);
                cheapestHotel = hotel;
            }
        }
        return cheapestHotel;

    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }
}

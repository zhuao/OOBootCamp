package com.tw.bootcamp.parkingstrategy;

import com.tw.bootcamp.ParkingLot;

import java.util.List;

public class AvailableSlotParkingStrategy implements IParkingStrategy {
    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        int maxAvailableSlots = 0;
        ParkingLot maxParkingLot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableSlots() > maxAvailableSlots) {
                maxAvailableSlots = parkingLot.getAvailableSlots();
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }
}

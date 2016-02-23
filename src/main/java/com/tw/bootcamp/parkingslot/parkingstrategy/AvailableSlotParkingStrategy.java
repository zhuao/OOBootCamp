package com.tw.bootcamp.parkingslot.parkingstrategy;

import com.tw.bootcamp.parkingslot.ParkingLot;

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

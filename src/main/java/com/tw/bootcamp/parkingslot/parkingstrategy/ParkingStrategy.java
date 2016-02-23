package com.tw.bootcamp.parkingslot.parkingstrategy;

import com.tw.bootcamp.parkingslot.ParkingLot;

import java.util.List;

public class ParkingStrategy implements IParkingStrategy {
    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableSlots() > 0) {
                return parkingLot;
            }
        }
        return null;
    }
}

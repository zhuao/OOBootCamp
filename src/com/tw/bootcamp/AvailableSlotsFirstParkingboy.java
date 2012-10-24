package com.tw.bootcamp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AvailableSlotsFirstParkingBoy extends AbstractParkingBoy {

    private List<ParkingLot> parkingLots;

    public AvailableSlotsFirstParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        parkingLots  = new LinkedList<ParkingLot>();
        parkingLots.add(parkingLot);
        parkingLots.addAll(Arrays.asList(parkingLotArray));
    }

    protected List<ParkingLot> getParkingLots(){
        return this.parkingLots;
    }

    protected ParkingLot getAvailableParkingLot(){
        int maxAvailableSlots = 0;
        ParkingLot maxParkingLot = null;
        for (ParkingLot parkingLot : getParkingLots()) {
            if (parkingLot.getAvailableSlots() > maxAvailableSlots) {
                maxAvailableSlots = parkingLot.getAvailableSlots();
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }

}

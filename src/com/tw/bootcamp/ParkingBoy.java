package com.tw.bootcamp;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParkingBoy  extends AbstractParkingBoy{

    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        parkingLots = new LinkedList<ParkingLot>();
        parkingLots.add(parkingLot);
        parkingLots.addAll(Arrays.asList(parkingLotArray));
    }

    @Override
    protected List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    @Override
    protected ParkingLot getAvailableParkingLot() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableSlots() > 0) {
                return parkingLot;
            }
        }
        throw new RuntimeException("no parking lot");
    }

}

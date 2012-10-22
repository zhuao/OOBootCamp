package com.tw.bootcamp;

public class AvailableSlotsFirstParkingBoy extends ParkingBoy{

    public AvailableSlotsFirstParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        super(parkingLot, parkingLotArray);
    }

    @Override
    protected ParkingLot getAvailableParkingLot() {
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

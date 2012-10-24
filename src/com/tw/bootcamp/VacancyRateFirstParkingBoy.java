package com.tw.bootcamp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class VacancyRateFirstParkingBoy extends AbstractParkingBoy{

    private List<ParkingLot> parkingLots;

    public VacancyRateFirstParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        this.parkingLots  = new LinkedList<ParkingLot>();
        this.parkingLots.add(parkingLot);
        this.parkingLots.addAll(Arrays.asList(parkingLotArray));
    }

    @Override
    protected List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }

    @Override
    protected ParkingLot getAvailableParkingLot() {
        float maxVacancyRate = 0;
        ParkingLot maxParkingLot = null;
        for (ParkingLot parkingLot : getParkingLots()) {
            if (parkingLot.getVacancyRate() > maxVacancyRate) {
                maxVacancyRate = parkingLot.getVacancyRate();
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }
}

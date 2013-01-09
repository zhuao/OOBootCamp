package com.tw.bootcamp.parkingslot.parkingstrategy;

import com.tw.bootcamp.parkingslot.ParkingLot;

import java.util.List;

public class VacancyRateFirstParkingStrategy implements IParkingStrategy {
    @Override
    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots) {
        float maxVacancyRate = 0;
        ParkingLot maxParkingLot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVacancyRate() > maxVacancyRate) {
                maxVacancyRate = parkingLot.getVacancyRate();
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }
}

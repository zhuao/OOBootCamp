package com.tw.bootcamp;

import com.tw.bootcamp.parkingstrategy.AvailableSlotParkingStrategy;
import com.tw.bootcamp.parkingstrategy.IParkingStrategy;
import com.tw.bootcamp.parkingstrategy.ParkingStrategy;
import com.tw.bootcamp.parkingstrategy.VacancyRateFirstParkingStrategy;

public enum ParkingBoyType {
    COMMON("CommonParkingBoy", new ParkingStrategy()),
    AVAILABLE_SLOT_FIRST("AvailableParkingBoy", new AvailableSlotParkingStrategy()),
    VACANCY_RATE_FIRST("VacancyrateParkingBoy", new VacancyRateFirstParkingStrategy()),
    MANAGER("ParkingManager", new ParkingStrategy());

    public IParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public String getReportName() {

        return reportName;
    }

    private String reportName;
    private IParkingStrategy parkingStrategy;

    ParkingBoyType(String reportName, IParkingStrategy parkingStrategy) {
        this.reportName = reportName;
        this.parkingStrategy = parkingStrategy;
    }
}

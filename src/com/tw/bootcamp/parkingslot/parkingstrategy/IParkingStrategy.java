package com.tw.bootcamp.parkingslot.parkingstrategy;

import com.tw.bootcamp.parkingslot.ParkingLot;

import java.util.List;

public interface IParkingStrategy {

    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots);


}

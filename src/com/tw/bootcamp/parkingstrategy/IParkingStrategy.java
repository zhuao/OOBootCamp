package com.tw.bootcamp.parkingstrategy;

import com.tw.bootcamp.IParkable;
import com.tw.bootcamp.ParkingLot;

import java.util.List;

public interface IParkingStrategy {

    public ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots);


}

package com.tw.bootcamp.printer;

import com.tw.bootcamp.ParkingBoy;
import com.tw.bootcamp.ParkingLot;
import com.tw.bootcamp.ParkingManager;

public interface Printer {
    String printParkingLot(ParkingLot parkingLot);

    String printParkingBoy(ParkingBoy parkingBoy);

    String printParkingManager(ParkingManager parkingManager);
}

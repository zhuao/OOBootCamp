package com.tw.bootcamp.parkingslot.printer;

import com.tw.bootcamp.parkingslot.ParkingBoy;
import com.tw.bootcamp.parkingslot.ParkingLot;
import com.tw.bootcamp.parkingslot.ParkingManager;

public interface Printer {
    String printParkingLot(ParkingLot parkingLot);

    String printParkingBoy(ParkingBoy parkingBoy);

    String printParkingManager(ParkingManager parkingManager);
}

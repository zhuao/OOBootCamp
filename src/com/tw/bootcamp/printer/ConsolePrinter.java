package com.tw.bootcamp.printer;

import com.tw.bootcamp.IParkable;
import com.tw.bootcamp.ParkingBoy;
import com.tw.bootcamp.ParkingLot;
import com.tw.bootcamp.ParkingManager;

public class ConsolePrinter implements Printer {

    @Override
    public String printParkingLot(ParkingLot parkingLot) {
        return parkingLot.getClass().getSimpleName() + ":" + parkingLot.getAvailableSlots() + "\n";
    }

    @Override
    public String printParkingBoy(ParkingBoy parkingBoy) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parkingBoy.getParkingBoyType().getReportName()).append(":").append(parkingBoy.getName()).append("\n");
        for (IParkable parkable : parkingBoy.getParkables()) {
            stringBuilder.append("  ").append(parkable.print(this));
        }
        return stringBuilder.toString();
    }

    @Override
    public String printParkingManager(ParkingManager parkingManager) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parkingManager.getParkingBoyType().getReportName()).append(":").append(parkingManager.getName()).append("\n");
        for (IParkable parkable : parkingManager.getParkables()) {
            stringBuilder.append(parkable.print(this));
        }
        String printString = stringBuilder.toString().replaceAll("\n", "\n  ");
        printString = printString.substring(0, printString.length() - 2);
        return printString;
    }

}

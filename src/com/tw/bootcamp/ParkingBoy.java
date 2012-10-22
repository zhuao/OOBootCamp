package com.tw.bootcamp;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParkingBoy {

    protected List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        parkingLots = new LinkedList<ParkingLot>();
        parkingLots.add(parkingLot);
        parkingLots.addAll(Arrays.asList(parkingLotArray));
    }

    public Ticket park(Car car) {
        Ticket ticket = new NullTicket();
        try{
            getAvailableParkingLot().receive(1);
            ticket = new Ticket();
            ticket.setCarNo(car.getCarNo());
        }catch (RuntimeException e) {
        }
        return ticket;
    }

    protected ParkingLot getAvailableParkingLot() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableSlots() > 0) {
                return parkingLot;
            }
        }
        throw new RuntimeException("no parking lot");
    }

}

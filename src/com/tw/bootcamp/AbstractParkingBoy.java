package com.tw.bootcamp;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractParkingBoy {

    protected abstract List<ParkingLot> getParkingLots();

    public Ticket park(Car car) {
        Ticket ticket = new NullTicket();
        try{
            getAvailableParkingLot().receive(1);
            ticket = new Ticket();
            ticket.setCarNo(car.getCarNo());
        }catch (RuntimeException e) {
//            e.printStackTrace();
        }
        return ticket;
    }

    protected abstract ParkingLot getAvailableParkingLot();
}

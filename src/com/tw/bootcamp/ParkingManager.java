package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.NullTicket;
import com.tw.bootcamp.domain.Ticket;
import com.tw.bootcamp.printer.Printer;

public class ParkingManager extends ParkingBoy {


    protected ParkingManager(IParkable parkingLot, IParkable... parkables) {
        super(parkingLot, parkables);
    }

    public Ticket park(Car car) {
        for (IParkable parkable : getParkables()) {
            Ticket ticket = parkable.park(car);
            if (ticket.isAvailable()) {
                return ticket;
            }
        }
        return new NullTicket();
    }

}

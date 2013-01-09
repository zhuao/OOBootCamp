package com.tw.bootcamp.parkingslot;

import com.tw.bootcamp.parkingslot.domain.Car;
import com.tw.bootcamp.parkingslot.domain.NullTicket;
import com.tw.bootcamp.parkingslot.domain.Ticket;

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

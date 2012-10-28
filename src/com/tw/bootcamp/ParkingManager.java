package com.tw.bootcamp;

import com.tw.bootcamp.parkingstrategy.ParkingStrategy;

import java.util.LinkedList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    private List<IParkable> parkingBoyes = new LinkedList<IParkable>();

    public ParkingManager(ParkingLot parkingLot, ParkingLot... parkingLots) {
        super(parkingLot, parkingLots);
        super.setParkingStrategy(new ParkingStrategy());
    }

    public void addManagedParkingBoy(IParkable parkingBoy) {
        parkingBoyes.add(parkingBoy);
    }

    public Ticket park(Car car) {
        Ticket ticket = super.park(car);
        if (!ticket.isAvailable()) {
            for (IParkable parkingBoy : parkingBoyes) {
                ticket = parkingBoy.park(car);
                if (ticket.isAvailable()) {
                    break;
                }
            }
        }
        return ticket;
    }
}

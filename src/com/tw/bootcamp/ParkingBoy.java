package com.tw.bootcamp;



public class ParkingBoy {

    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        try{
            parkingLot.receive(1);
            ticket = new Ticket();
            ticket.setCarNo(car.getCarNo());
        }catch (RuntimeException e) {
        }
        return ticket;
    }
}

package com.tw.bootcamp;

public class ParkingLot implements IParkable{

    private int availableSlots;
    private int amount;

    public ParkingLot(int amount) {
        this.amount = amount;
    }

    public ParkingLot(int amount, int availableSlots) {
        this.amount = amount;
        this.availableSlots = availableSlots;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket;
        availableSlots --;
        ticket = new Ticket();
        ticket.setCarNo(car.getCarNo());
        if (availableSlots < 0) {
            ticket = new NullTicket();
        }
        return ticket;
    }

    public int send(int carCount) {
        if(availableSlots==0)
        {
            throw new RuntimeException("have no parking car!");
        }
        availableSlots = availableSlots + carCount;
        return availableSlots;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public float getVacancyRate() {
        return (float) availableSlots / (float) amount;
    }
}

package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.NullTicket;
import com.tw.bootcamp.domain.Ticket;

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
            availableSlots = 0;
            ticket = new NullTicket();
        }
        return ticket;
    }

    @Override
    public String report(int indentLength) {
        return buildWhiteSpace(indentLength) + this.getClass().getSimpleName() + ":" + getAvailableSlots() + "\n";
    }

    private String buildWhiteSpace(int indentLength) {
        String whiteSpace = "";
        while (indentLength -- > 0) {
            whiteSpace += " ";
        }
        return whiteSpace;
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

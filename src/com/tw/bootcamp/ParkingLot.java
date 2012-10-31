package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.NullTicket;
import com.tw.bootcamp.domain.Ticket;
import com.tw.bootcamp.printer.Printer;

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
        if (availableSlots <= 0) {
            return new NullTicket();
        }
        availableSlots--;

        Ticket ticket = new Ticket();
        ticket.setCarNo(car.getCarNo());
        return ticket;
    }

    @Override
    public String print(Printer printer) {
        return printer.printParkingLot(this);
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

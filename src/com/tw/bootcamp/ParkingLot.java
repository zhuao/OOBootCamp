package com.tw.bootcamp;

public class ParkingLot {

    private int availableSlots;
    private int amount;

    public ParkingLot(int amount) {
        this.amount = amount;
    }

    public ParkingLot(int amount, int availableSlots) {
        this.amount = amount;
        this.availableSlots = availableSlots;
    }

    public int receive(int carCount) {
        availableSlots = availableSlots - carCount;
        if (availableSlots < 0) {
            throw new RuntimeException("have no available parking lot!");
        }
        return  availableSlots;
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

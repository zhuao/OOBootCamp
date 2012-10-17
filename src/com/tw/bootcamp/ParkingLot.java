package com.tw.bootcamp;

/**
 * Created with IntelliJ IDEA.
 * User: zhuao
 * Date: 10/16/12
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLot {

    private int availableSlots;

    public ParkingLot(int availableSlots) {
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
}

package com.tw.bootcamp;

import junit.framework.Assert;
import org.junit.Test;


public class ParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_successful_in_his_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(expectedCarNo, ticket.getCarNo());

    }

    @Test
    public void should_not_return_ticket_when_fail_park_in_his_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertNull(ticket);
    }
}

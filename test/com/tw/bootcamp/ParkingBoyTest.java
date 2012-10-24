package com.tw.bootcamp;

import junit.framework.Assert;
import org.junit.Test;


public class ParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_successful_in_his_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(10, 3);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(expectedCarNo, ticket.getCarNo());

    }

    @Test
    public void should_not_return_ticket_when_fail_park_in_his_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(10, 0);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertFalse(ticket.isAvailable());
    }

    @Test
    public void should_return_ticket_when_park_successfully_in_his_first_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(10, 3);
        ParkingLot secondParkingLot = new ParkingLot(10, 3);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(expectedCarNo, ticket.getCarNo());
        Assert.assertEquals(2, firstParkingLot.getAvailableSlots());
        Assert.assertEquals(3, secondParkingLot.getAvailableSlots());
    }

    @Test
    public void should_return_ticket_when_park_successfully_in_second_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(10, 0);
        ParkingLot secondParkingLot = new ParkingLot(10, 3);
        ParkingLot thirdParkingLot = new ParkingLot(10, 4);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot, thirdParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(expectedCarNo, ticket.getCarNo());
        Assert.assertEquals(0, firstParkingLot.getAvailableSlots());
        Assert.assertEquals(2, secondParkingLot.getAvailableSlots());
        Assert.assertEquals(4, thirdParkingLot.getAvailableSlots());
    }

    @Test
    public void should_return_ticket_when_park_successfully_in_his_second_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(10, 0);
        ParkingLot secondParkingLot = new ParkingLot(10, 3);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(expectedCarNo, ticket.getCarNo());
        Assert.assertEquals(0, firstParkingLot.getAvailableSlots());
        Assert.assertEquals(2, secondParkingLot.getAvailableSlots());
    }

    @Test
    public void should_not_return_ticket_when_no_parking_lots_in_his_all_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(10, 0);
        ParkingLot secondParkingLot = new ParkingLot(10, 0);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertFalse(ticket.isAvailable());
    }


}

package com.tw.bootcamp;

import junit.framework.Assert;
import org.junit.Test;

public class AvailableSlotsFirstParkingBoyTest {

    @Test
    public void should_park_successful_when_two_parking_lots_has_same_available_slots() {
        ParkingLot firstParkingLot = new ParkingLot(10, 3);
        ParkingLot secondParkingLot = new ParkingLot(10, 3);
        IParkable parkingBoy = ParkingBoy.createAvailableSlotsFirstParkingBoy(firstParkingLot, secondParkingLot);
        int totalAvailableSlots = getCurrentTotalAvailableSlot(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isAvailable());
        int actualAvailableSlots = getCurrentTotalAvailableSlot(firstParkingLot, secondParkingLot);
        Assert.assertEquals(totalAvailableSlots - 1, actualAvailableSlots);
    }

    @Test
    public void should_park_in_more_available_slots_when_two_parking_lots_has_different_available_slot() {
        ParkingLot firstParkingLot = new ParkingLot(10, 3);
        ParkingLot secondParkingLot = new ParkingLot(10, 5);
        IParkable parkingBoy = ParkingBoy.createAvailableSlotsFirstParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(4, secondParkingLot.getAvailableSlots());
        Assert.assertEquals(3, firstParkingLot.getAvailableSlots());
    }

    @Test
    public void should_fail_to_park_when_two_parking_lots_has_no_available_slot() {
        ParkingLot firstParkingLot = new ParkingLot(10, 0);
        ParkingLot secondParkingLot = new ParkingLot(10, 0);
        IParkable parkingBoy = ParkingBoy.createAvailableSlotsFirstParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertFalse(ticket.isAvailable());
    }

    private int getCurrentTotalAvailableSlot(ParkingLot... parkingLots) {
        int totalAvailableSlots = 0;
        for (ParkingLot parkingLot : parkingLots) {
            totalAvailableSlots += parkingLot.getAvailableSlots();
        }
        return totalAvailableSlots;
    }
}

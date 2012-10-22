package com.tw.bootcamp;

import junit.framework.Assert;
import org.junit.Test;

public class AvailableSlotsFirstParkingBoyTest {

    @Test
    public void should_park_successful_when_two_parking_lots_has_same_available_slots() {
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(3);
        ParkingBoy parkingBoy = new AvailableSlotsFirstParkingBoy(firstParkingLot, secondParkingLot);
        int totalAvailableSlots = getCurrentTotalAvailableSlot(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertFalse(ticket.isNUll());
        int actualAvailableSlots = getCurrentTotalAvailableSlot(firstParkingLot, secondParkingLot);
        Assert.assertEquals(totalAvailableSlots - 1, actualAvailableSlots);
    }

    @Test
    public void should_park_in_more_available_slots_when_two_parking_lots_has_different_available_slot() {
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new AvailableSlotsFirstParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertFalse(ticket.isNUll());
        Assert.assertEquals(4, secondParkingLot.getAvailableSlots());
        Assert.assertEquals(3, firstParkingLot.getAvailableSlots());
    }

    @Test
    public void should_fail_to_park_when_two_parking_lots_has_no_available_slot() {
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot(0);
        ParkingBoy parkingBoy = new AvailableSlotsFirstParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isNUll());
    }

    private int getCurrentTotalAvailableSlot(ParkingLot... parkingLots) {
        int totalAvailableSlots = 0;
        for (ParkingLot parkingLot : parkingLots) {
            totalAvailableSlots += parkingLot.getAvailableSlots();
        }
        return totalAvailableSlots;
    }
}

package com.tw.bootcamp;

import junit.framework.Assert;
import org.junit.Test;

public class ParkTest {

    @Test
    public void should_return_2_available_slots_when_park_successful_and_parking_lot_has_3_available_slots() {
        int availableSlots = 3;
        ParkingLot parkingLot = new ParkingLot(availableSlots);

        int availableCount = parkingLot.receive(1);

        Assert.assertEquals(2, availableCount);

    }

    @Test
    public void should_return_3_available_slots_when_park_successful_and_parking_lot_has_4_available_slots() {
        int availableSlots = 4;
        ParkingLot parkingLot = new ParkingLot(availableSlots);

        int availableCount = parkingLot.receive(1);

        Assert.assertEquals(3, availableCount);

    }

    @Test
    public void should_return_exception_when_fail_park_and_parking_lot_has_0_available_slots() {
        int availableSlots = 0;
        ParkingLot parkingLot = new ParkingLot(availableSlots);

        try {
            parkingLot.receive(1);
            Assert.fail();
        } catch (RuntimeException e) {
            Assert.assertEquals("have no available parking lot!", e.getMessage());
        }
    }

    @Test
    public void should_return_4_available_slots_when_unpark_successful_and_parking_lot_has_3_available_slots() {
        int availableSlots = 3;
        ParkingLot parkingLot = new ParkingLot(availableSlots);

        int availableCount = parkingLot.send(1);

        Assert.assertEquals(4, availableCount);

    }

    @Test
    public void should_return_3_available_slots_when_unpark_successful_and_parking_slot_has_2_available_slots() {
        int availableSlots = 2;
        ParkingLot parkingLot = new ParkingLot(availableSlots);

        int availableCount = parkingLot.send(1);

        Assert.assertEquals(3, availableCount);

    }

    @Test
    public void should_return_exception_when_fail_unpark_and_all_parking_slot_are_available_slots() {
        int availableSlots = 0;
        ParkingLot parkingLot = new ParkingLot(availableSlots);

        try {
            parkingLot.send(1);
            Assert.fail();
        } catch (RuntimeException e) {
            Assert.assertEquals("have no parking car!", e.getMessage());
        }
    }
}

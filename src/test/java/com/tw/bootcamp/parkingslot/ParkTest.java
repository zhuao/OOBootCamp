package com.tw.bootcamp.parkingslot;

import com.tw.bootcamp.parkingslot.domain.Car;
import com.tw.bootcamp.parkingslot.domain.Ticket;
import com.tw.bootcamp.parkingslot.ParkingLot;
import junit.framework.Assert;
import org.junit.Test;

public class ParkTest {

    @Test
    public void should_return_2_available_slots_when_park_successful_and_parking_lot_has_3_available_slots() {
        int availableSlots = 3;
        ParkingLot parkingLot = new ParkingLot(10, availableSlots);

        parkingLot.park(new Car("12345"));

        Assert.assertEquals(2, parkingLot.getAvailableSlots());

    }

    @Test
    public void should_return_3_available_slots_when_park_successful_and_parking_lot_has_4_available_slots() {
        int availableSlots = 4;
        ParkingLot parkingLot = new ParkingLot(10, availableSlots);

        parkingLot.park(new Car("12345"));

        Assert.assertEquals(3, parkingLot.getAvailableSlots());

    }

    @Test
    public void should_return_exception_when_fail_park_and_parking_lot_has_0_available_slots() {
        int availableSlots = 0;
        ParkingLot parkingLot = new ParkingLot(10, availableSlots);

        Ticket ticket = parkingLot.park(new Car("12345"));

        Assert.assertFalse(ticket.isAvailable());
    }

    @Test
    public void should_return_4_available_slots_when_unpark_successful_and_parking_lot_has_3_available_slots() {
        int availableSlots = 3;
        ParkingLot parkingLot = new ParkingLot(10, availableSlots);

        parkingLot.send(1);

        Assert.assertEquals(4, parkingLot.getAvailableSlots());

    }

    @Test
    public void should_return_3_available_slots_when_unpark_successful_and_parking_slot_has_2_available_slots() {
        int availableSlots = 2;
        ParkingLot parkingLot = new ParkingLot(10, availableSlots);

        parkingLot.send(1);

        Assert.assertEquals(3, parkingLot.getAvailableSlots());

    }

    @Test
    public void should_return_exception_when_fail_unpark_and_all_parking_slot_are_available_slots() {
        int availableSlots = 0;
        ParkingLot parkingLot = new ParkingLot(10, availableSlots);

        try {
            parkingLot.send(1);
            Assert.fail();
        } catch (RuntimeException e) {
            Assert.assertEquals("have no parking car!", e.getMessage());
        }
    }
}

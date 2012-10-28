package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.Ticket;
import junit.framework.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void should_park_fail_when_there_is_no_available_slot() {
        ParkingLot parkingLot = new ParkingLot(10, 0);

        Ticket ticket = parkingLot.park(new Car("jieg"));

        Assert.assertFalse(ticket.isAvailable());
        Assert.assertEquals(0, parkingLot.getAvailableSlots());
    }

    @Test
    public void should_park_three_times_successfully_when_there_are_three_available_slots() {
        ParkingLot parkingLot = new ParkingLot(10, 3);

        Ticket firstTicket = parkingLot.park(new Car("jieg"));
        Assert.assertTrue(firstTicket.isAvailable());
        Assert.assertEquals(2, parkingLot.getAvailableSlots());

        Ticket secondTicket = parkingLot.park(new Car("jieg"));
        Assert.assertTrue(secondTicket.isAvailable());
        Assert.assertEquals(1, parkingLot.getAvailableSlots());

        Ticket thirdTicket = parkingLot.park(new Car("jieg"));
        Assert.assertTrue(thirdTicket.isAvailable());
        Assert.assertEquals(0, parkingLot.getAvailableSlots());
    }



}

package com.tw.bootcamp;

import junit.framework.Assert;
import org.junit.Test;

public class VacancyRateFirstParkingBoyTest {

    @Test
    public void should_park_successful_when_two_parking_lots_has_same_vacancy_rate() {
        ParkingLot firstParkingLot = new ParkingLot(12, 3);
        ParkingLot secondParkingLot = new ParkingLot(12, 3);
        VacancyRateFirstParkingBoy parkingBoy = new VacancyRateFirstParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isAvailable());
    }

    @Test
    public void should_park_in_high_vacancy_rate_parking_lot_when_two_parking_lots_has_different_vacancy_rate() {
        ParkingLot firstParkingLot = new ParkingLot(15, 3);
        ParkingLot secondParkingLot = new ParkingLot(12, 3);
        VacancyRateFirstParkingBoy parkingBoy = new VacancyRateFirstParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(3, firstParkingLot.getAvailableSlots());
        Assert.assertEquals(2, secondParkingLot.getAvailableSlots());
    }

    @Test
    public void should_fail_to_park_when_there_are_no_available_slots() {
        ParkingLot firstParkingLot = new ParkingLot(10, 0);
        ParkingLot secondParkingLot = new ParkingLot(10, 0);
        AvailableSlotsFirstParkingBoy parkingBoy = new AvailableSlotsFirstParkingBoy(firstParkingLot, secondParkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingBoy.park(car);

        Assert.assertFalse(ticket.isAvailable());
    }
}

package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.Ticket;
import junit.framework.Assert;
import org.junit.Test;

public class ParkingManagerTest {

    @Test
    public void should_parking_successfully_when_parking_manager_has_one_parking_lot_and_has_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(10, 5);
        ParkingManager parkingManager = ParkingBoy.createParkingManager(parkingLot);

        String expectedCarNo = "1215";
        Car car = new Car(expectedCarNo);
        Ticket ticket = parkingManager.park(car);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(4, parkingLot.getAvailableSlots());
    }

    @Test
    public void should_parking_twice_successfully_when_parking_manager_has_one_parking_lot_and_one_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(10, 1);
        ParkingLot boyParkingLot = new ParkingLot(20,1);
        IParkable commonParkingBoy = ParkingBoy.createCommonParkingBoy(boyParkingLot);
        ParkingManager parkingManager = ParkingBoy.createParkingManager(parkingLot, commonParkingBoy);

        String expectedCarNo = "1215";
        Car firstCar = new Car(expectedCarNo);
        Car secondCar = new Car(expectedCarNo);
        Ticket ticket = parkingManager.park(firstCar);
        parkingManager.park(secondCar);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(0, parkingLot.getAvailableSlots());
        Assert.assertEquals(0, boyParkingLot.getAvailableSlots());

    }

    @Test
    public void should_parking_three_times_successfully_when_parking_manager_has_one_parking_lot_and_two_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(10, 1);

        ParkingLot firstParkingLot = new ParkingLot(20,1);
        IParkable commonParkingBoy = ParkingBoy.createCommonParkingBoy(firstParkingLot);

        ParkingLot secondParkingLot = new ParkingLot(20,1);
        IParkable secondCommonParkingBoy = ParkingBoy.createCommonParkingBoy(secondParkingLot);
        ParkingManager parkingManager = ParkingBoy.createParkingManager(parkingLot, commonParkingBoy, secondCommonParkingBoy);

        String expectedCarNo = "1215";
        Car firstCar = new Car(expectedCarNo);
        Car secondCar = new Car(expectedCarNo);
        Car thirdCar = new Car(expectedCarNo);
        Ticket ticket = parkingManager.park(firstCar);
        parkingManager.park(secondCar);
        parkingManager.park(thirdCar);

        Assert.assertTrue(ticket.isAvailable());
        Assert.assertEquals(0, parkingLot.getAvailableSlots());
        Assert.assertEquals(0, firstParkingLot.getAvailableSlots());
        Assert.assertEquals(0, secondParkingLot.getAvailableSlots());

    }

}

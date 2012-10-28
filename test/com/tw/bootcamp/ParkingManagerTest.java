package com.tw.bootcamp;

import junit.framework.Assert;
import org.junit.Test;

public class ParkingManagerTest {

    @Test
    public void should_parking_successfully_when_parking_manager_has_a_parking_lot_and_has_no_parking_boy() {
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
        ParkingManager parkingManager = ParkingBoy.createParkingManager(parkingLot);

        ParkingLot boyParkingLot = new ParkingLot(20,1);
        IParkable commonParkingBoy = ParkingBoy.createCommonParkingBoy(boyParkingLot);
        parkingManager.addManagedParkingBoy(commonParkingBoy);

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
        ParkingManager parkingManager = ParkingBoy.createParkingManager(parkingLot);

        ParkingLot firstParkingLot = new ParkingLot(20,1);
        IParkable commonParkingBoy = ParkingBoy.createCommonParkingBoy(firstParkingLot);
        parkingManager.addManagedParkingBoy(commonParkingBoy);

        ParkingLot secondParkingLot = new ParkingLot(20,1);
        IParkable secondCommonParkingBoy = ParkingBoy.createCommonParkingBoy(secondParkingLot);
        parkingManager.addManagedParkingBoy(secondCommonParkingBoy);

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

//    @Test
//    public void should_print_all_parking_lots_when_it_has_2_parking_boy() {
//
//        ParkingLot parkingLot = new ParkingLot(10, 1);
//        ParkingManager parkingManager = new ParkingManager(parkingLot);
//        parkingManager.setName("zhangsan");
//
//        ParkingLot firstParkingLot = new ParkingLot(20,1);
//        CommonParkingBoy parkingBoy = new CommonParkingBoy(firstParkingLot);
//        parkingBoy.setName("lisi");
//        parkingManager.addManagedParkingBoy(parkingBoy);
//
//        ParkingLot secondParkingLot = new ParkingLot(20,1);
//        CommonParkingBoy secondParkingBoy = new CommonParkingBoy(secondParkingLot);
//        secondParkingBoy.setName("wangwu");
//        parkingManager.addManagedParkingBoy(secondParkingBoy);
//
//        String tree = parkingManager.print();
//
//        System.out.println(tree);
//
//        Assert.assertEquals("ParkingManager:zhangsan\n  CommonParkingBoy:lisi\n    ParkingLot:1\n  CommonParkingBoy:wangwu\n    ParkingLot:1", tree);
//
//    }
}

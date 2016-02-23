package com.tw.bootcamp.parkingslot;

import com.tw.bootcamp.parkingslot.ParkingBoy;
import com.tw.bootcamp.parkingslot.ParkingLot;
import com.tw.bootcamp.parkingslot.ParkingManager;
import com.tw.bootcamp.parkingslot.printer.ConsolePrinter;
import junit.framework.Assert;
import org.junit.Test;

public class ConsolePrinterTest {

    @Test
    public void should_print_parking_lot_information() {

        ParkingLot parkingLot = new ParkingLot(10, 2);

        String out = parkingLot.print(new ConsolePrinter());

        Assert.assertEquals("print wrong report:", "ParkingLot:2\n", out);
    }

    @Test
    public void should_print_parking_boy_information_when_it_has_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(10, 2);
        ParkingBoy commonParkingBoy = ParkingBoy.createCommonParkingBoy(parkingLot);
        commonParkingBoy.setName("lisi");

        String out = commonParkingBoy.print(new ConsolePrinter());

        Assert.assertEquals("print wrong report:", "CommonParkingBoy:lisi\n  ParkingLot:2\n", out);
    }

    @Test
    public void should_print_parking_boy_information_when_it_has_two_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(10, 2);
        ParkingLot secondParkingLot = new ParkingLot(10, 3);
        ParkingBoy commonParkingBoy = ParkingBoy.createCommonParkingBoy(parkingLot, secondParkingLot);
        commonParkingBoy.setName("lisi");

        String out = commonParkingBoy.print(new ConsolePrinter());

        Assert.assertEquals("print wrong report:", "CommonParkingBoy:lisi\n  ParkingLot:2\n  ParkingLot:3\n", out);
    }

    @Test
    public void should_print_parking_manager_when_it_has_2_parking_boy() {

        ParkingLot parkingLot = new ParkingLot(10, 1);
        ParkingLot firstParkingLot = new ParkingLot(20,1);
        ParkingBoy parkingBoy = ParkingBoy.createCommonParkingBoy(firstParkingLot);
        parkingBoy.setName("lisi");
        ParkingLot secondParkingLot = new ParkingLot(20,1);
        ParkingBoy secondParkingBoy = ParkingBoy.createCommonParkingBoy(secondParkingLot);
        secondParkingBoy.setName("wangwu");

        ParkingManager parkingManager = ParkingBoy.createParkingManager(parkingLot, parkingBoy, secondParkingBoy);
        parkingManager.setName("zhangsan");


        String tree = parkingManager.print(new ConsolePrinter());

        System.out.println(tree);
        Assert.assertEquals("ParkingManager:zhangsan\n  ParkingLot:1\n  CommonParkingBoy:lisi\n    ParkingLot:1\n  CommonParkingBoy:wangwu\n    ParkingLot:1\n", tree);

    }
}

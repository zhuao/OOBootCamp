package com.tw.bootcamp;

import com.tw.bootcamp.parkingstrategy.AvailableSlotParkingStrategy;
import com.tw.bootcamp.parkingstrategy.IParkingStrategy;
import com.tw.bootcamp.parkingstrategy.ParkingStrategy;
import com.tw.bootcamp.parkingstrategy.VacancyRateFirstParkingStrategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParkingBoy implements IParkable {

    private List<ParkingLot> parkingLots;
    private IParkingStrategy parkingStrategy;

    protected ParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLots) {
        this.parkingLots = new LinkedList<ParkingLot>();
        this.parkingLots.add(parkingLot);
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public static IParkable createCommonParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot, parkingLotArray);
        parkingBoy.setParkingStrategy(new ParkingStrategy());
        return parkingBoy;
    }

    public static IParkable createAvailableSlotsFirstParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot, parkingLotArray);
        parkingBoy.setParkingStrategy(new AvailableSlotParkingStrategy());
        return parkingBoy;
    }

    public static IParkable createVacancyRateFirstParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot, parkingLotArray);
        parkingBoy.setParkingStrategy(new VacancyRateFirstParkingStrategy());
        return parkingBoy;
    }

    public static ParkingManager createParkingManager(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        return new ParkingManager(parkingLot, parkingLotArray);
    }

    protected void setParkingStrategy(IParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket;
        try{
            ticket = this.parkingStrategy.getAvailableParkingLot(parkingLots).park(car);

        }catch (RuntimeException e) {
//            e.printStackTrace();
            ticket = new NullTicket();
        }
        return ticket;
    }

}

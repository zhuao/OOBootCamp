package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.NullTicket;
import com.tw.bootcamp.domain.Ticket;
import com.tw.bootcamp.printer.Printer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParkingBoy implements IParkable {

    private List<IParkable> parkables;
    private String name;

    private ParkingBoyType parkingBoyType;

    protected ParkingBoy(IParkable parkingLot, IParkable... parkables) {
        this.parkables = new LinkedList<IParkable>();
        this.parkables.add(parkingLot);
        this.parkables.addAll(Arrays.asList(parkables));
    }

    public static ParkingBoy createCommonParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot, parkingLotArray);
        parkingBoy.setParkingBoyType(ParkingBoyType.COMMON);
        return parkingBoy;
    }

    public static ParkingBoy createAvailableSlotsFirstParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot, parkingLotArray);
        parkingBoy.setParkingBoyType(ParkingBoyType.AVAILABLE_SLOT_FIRST);
        return parkingBoy;
    }

    public static ParkingBoy createVacancyRateFirstParkingBoy(ParkingLot parkingLot, ParkingLot... parkingLotArray) {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot, parkingLotArray);
        parkingBoy.setParkingBoyType(ParkingBoyType.VACANCY_RATE_FIRST);
        return parkingBoy;
    }

    public static ParkingManager createParkingManager(IParkable parkingLot, IParkable... parkingLotArray) {
        ParkingManager parkingManager = new ParkingManager(parkingLot, parkingLotArray);
        parkingManager.setParkingBoyType(ParkingBoyType.MANAGER);
        return parkingManager;
    }

    protected void setParkingBoyType(ParkingBoyType parkingBoyType) {
        this.parkingBoyType = parkingBoyType;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket;

        try{
            ticket = parkingBoyType.getParkingStrategy().getAvailableParkingLot(getParkingLot(parkables)).park(car);

        }catch (RuntimeException e) {
//            e.printStackTrace();
            ticket = new NullTicket();
        }
        return ticket;
    }


    @Override
    public String print(Printer printer) {
        return printer.printParkingBoy(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IParkable> getParkables() {
        return this.parkables;
    }

    private List<ParkingLot> getParkingLot(List<IParkable> parkables) {
        List<ParkingLot> parkingLots = new LinkedList<ParkingLot>();
        for (IParkable parkable : parkables) {
            if (parkable instanceof ParkingLot) {
                parkingLots.add((ParkingLot) parkable);
            }
        }
        return parkingLots;
    }

    public ParkingBoyType getParkingBoyType() {
        return parkingBoyType;
    }
}

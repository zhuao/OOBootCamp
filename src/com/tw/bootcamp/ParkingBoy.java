package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.NullTicket;
import com.tw.bootcamp.domain.Ticket;
import com.tw.bootcamp.parkingstrategy.IParkingStrategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParkingBoy implements IParkable {

    private List<IParkable> parkables;
    private IParkingStrategy parkingStrategy;
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
        setParkingStrategy(parkingBoyType.getParkingStrategy());
    }

    private void setParkingStrategy(IParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket;

        try{
            ticket = this.parkingStrategy.getAvailableParkingLot(getParkingLot(parkables)).park(car);

        }catch (RuntimeException e) {
//            e.printStackTrace();
            ticket = new NullTicket();
        }
        return ticket;
    }

    @Override
    public String report(int indentLength) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(buildWhiteSpace(indentLength)).append(this.parkingBoyType.getReportName()).append(":").append(getName()).append("\n");
        for (IParkable parkingLot : parkables) {
            strBuilder.append(parkingLot.report(indentLength + 2));
        }
        return strBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected List<IParkable> getParkables() {
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

    private String buildWhiteSpace(int indentLength) {
        String whiteSpace = "";
        while (indentLength -- > 0) {
            whiteSpace += " ";
        }
        return whiteSpace;
    }

}

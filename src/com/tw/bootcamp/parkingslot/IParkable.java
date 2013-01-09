package com.tw.bootcamp.parkingslot;

import com.tw.bootcamp.parkingslot.domain.Car;
import com.tw.bootcamp.parkingslot.domain.Ticket;
import com.tw.bootcamp.parkingslot.printer.Printer;

public interface IParkable {
    Ticket park(Car car);

    String print(Printer printer);
}

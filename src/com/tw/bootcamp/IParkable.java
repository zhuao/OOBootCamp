package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.Ticket;
import com.tw.bootcamp.printer.Printer;

public interface IParkable {
    Ticket park(Car car);

    String print(Printer printer);
}

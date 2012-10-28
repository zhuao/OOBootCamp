package com.tw.bootcamp;

import com.tw.bootcamp.domain.Car;
import com.tw.bootcamp.domain.Ticket;

public interface IParkable {
    Ticket park(Car car);

    String report(int indentLength);
}

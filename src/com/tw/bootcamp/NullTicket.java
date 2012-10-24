package com.tw.bootcamp;

public class NullTicket extends Ticket{

    @Override
    public boolean isAvailable() {
        return false;
    }
}

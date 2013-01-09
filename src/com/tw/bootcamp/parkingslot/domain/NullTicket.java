package com.tw.bootcamp.parkingslot.domain;

public class NullTicket extends Ticket {

    @Override
    public boolean isAvailable() {
        return false;
    }
}

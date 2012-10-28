package com.tw.bootcamp.domain;

public class NullTicket extends Ticket {

    @Override
    public boolean isAvailable() {
        return false;
    }
}

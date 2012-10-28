package com.tw.bootcamp.domain;

public class Ticket {

    private String carNo;

    public String getCarNo() {
        return this.carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public boolean isAvailable() {
        return true;
    }
}

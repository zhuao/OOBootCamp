package com.tw.bootcamp.parkingslot.domain;

public class Car {

    private final String carNo;

    public Car(String carNo) {
        this.carNo = carNo;
    }

    public String getCarNo() {
        return this.carNo;
    }
}

package com.tw.bootcamp.guesslength;

public class Length {
    private int length;
    private LengthUnit unit;

    public Length(int length, LengthUnit unit) {
        this.length = length;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Length) obj).unit.absoluteValue(((Length) obj).length) == unit.absoluteValue(length);
    }
}

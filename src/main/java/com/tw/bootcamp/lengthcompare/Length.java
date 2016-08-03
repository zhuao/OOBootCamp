package com.tw.bootcamp.lengthcompare;

public class Length {
    private int length;
    private LengthUnit unit;

    public Length(int length, LengthUnit unit) {
        this.length = length;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Length) obj).getAtomValue() == getAtomValue();
    }

    private int getAtomValue() {
        return length * unit.value();
    }
}

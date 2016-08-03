package com.tw.bootcamp.lengthcompare;

public enum LengthUnit {
    M {
        public int value() {
            return 100;
        }
    },
    CM {

        public int value() {
            return 1;
        }
    };

    abstract public int value();
}


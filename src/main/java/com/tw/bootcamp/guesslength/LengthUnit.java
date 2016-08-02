package com.tw.bootcamp.guesslength;

public enum LengthUnit {
    M {
        @Override
        public int absoluteValue(int length) {
            return length * 100;
        }
    }, CM {
        @Override
        public int absoluteValue(int length) {
            return length * 1;
        }
    };

    abstract public int absoluteValue(int length);
}


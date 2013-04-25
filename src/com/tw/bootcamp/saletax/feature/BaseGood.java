package com.tw.bootcamp.saletax.feature;

public class BaseGood implements GoodFeature{

    private GoodFeature feature;

    @Override
    public float getSaleTax(float amount) {
        return feature.getSaleTax(amount) + 0.1f;
    }
}

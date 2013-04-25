package com.tw.bootcamp.saletax.SaleTaxStrategy;

import com.tw.bootcamp.saletax.feature.GoodFeature;

public class BaseGoodFeature implements GoodFeature {

    private GoodFeature feature;
    @Override
    public float getSaleTax(float amount) {
        return feature.getSaleTax(amount) + feature.getSaleTax(amount);
    }
}

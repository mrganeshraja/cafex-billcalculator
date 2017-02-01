package com.capgemini.ddctdev.exercise.basic;

public class DrinkItem extends Item {

    public DrinkItem(String name, String temp, double cost) {
        super(name, temp, cost);
        setServiceCharge(0);
    }

    @Override
    public double getCost() {
        return super.getCost();
    }
}

package com.capgemini.ddctdev.exercise.basic;

public class FoodItem extends Item {

    public FoodItem(String name, double cost) {
        super(name, "cold", cost);
        setServiceCharge(10);
    }

    @Override
    public double getCost() {
        return super.getCost();
    }
}

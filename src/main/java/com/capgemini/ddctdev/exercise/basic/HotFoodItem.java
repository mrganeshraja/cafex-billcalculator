package com.capgemini.ddctdev.exercise.basic;

public class HotFoodItem extends Item {

    public HotFoodItem(String name, double cost) {
        super(name, "hot", cost);
        setServiceCharge(20);
    }

    @Override
    public double getCost() {
        return super.getCost();
    }
}

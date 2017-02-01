package com.capgemini.ddctdev.exercise.basic;

/**
 * Item class
 *
 * @author Ganesh Raja
 * @since 0.1
 */
public class Item {

    private String name ;

    private String temp;

    private double cost;

    private double serviceCharge;

    public Item(String name, String temp, double cost) {
        this.name = name;
        this.temp = temp;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public String toString() {
        return name + "-" + temp + "-" + cost;
    }
}

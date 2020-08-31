package com.pattern.structural.adapter;

public class MovableAdapterImpl implements MovableAdapter{
    private Movable cars;

    public MovableAdapterImpl(Movable cars) {
        this.cars = cars;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(cars.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}

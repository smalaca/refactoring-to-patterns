package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain;

public class Temperature {
    private final int value;

    public Temperature(int value) {
        this.value = value;
    }

    public boolean lowerThan(Temperature temperature) {
        return value < temperature.value;
    }

    public boolean higherThan(Temperature temperature) {
        return value > temperature.value;
    }
}

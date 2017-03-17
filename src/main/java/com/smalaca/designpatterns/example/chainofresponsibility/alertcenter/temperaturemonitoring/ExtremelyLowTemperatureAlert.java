package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;

class ExtremelyLowTemperatureAlert implements TemperatureControl {
    private final Temperature tooLowTemperature;
    private final TemperatureControl next;

    ExtremelyLowTemperatureAlert(Temperature tooLowTemperature, TemperatureControl next) {
        this.tooLowTemperature = tooLowTemperature;
        this.next = next;
    }

    @Override
    public void reactOn(Temperature temperature) {
        if (temperature.lowerThan(temperature)) {
            increaseHeating();
            orderLotOfHotTee();
        } else {
            next.reactOn(temperature);
        }
    }

    private void increaseHeating() {

    }

    private void orderLotOfHotTee() {

    }
}

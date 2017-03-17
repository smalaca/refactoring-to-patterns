package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;

class ExtremelyHighTemperatureAlert implements TemperatureControl {
    private final Temperature tooHighTemperature;
    private final TemperatureControl next;

    ExtremelyHighTemperatureAlert(Temperature tooHighTemperature, TemperatureControl next) {
        this.tooHighTemperature = tooHighTemperature;
        this.next = next;
    }

    @Override
    public void reactOn(Temperature temperature) {
        if (temperature.lowerThan(temperature)) {
            turnOnFan();
            startProduceIce();
            orderSomethingColdToDrink();
        } else {
            next.reactOn(temperature);
        }
    }

    private void orderSomethingColdToDrink() {

    }

    private void startProduceIce() {

    }

    private void turnOnFan() {

    }
}

package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring.TemperatureControl;

class AlertCenter {
    private final TemperatureControl temperatureControl;

    AlertCenter(TemperatureControl alerts) {
        temperatureControl = alerts;
    }

    void verify(Temperature temperature) {
        temperatureControl.reactOn(temperature);
    }
}

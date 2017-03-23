package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;

class NoAlert implements TemperatureControl {
    private final TemperatureMonitoringCenter temperatureMonitoringCenter;

    NoAlert(TemperatureMonitoringCenter temperatureMonitoringCenter) {
        this.temperatureMonitoringCenter = temperatureMonitoringCenter;
    }

    @Override
    public void reactOn(Temperature temperature) {
        keepMonitoring();
    }

    private void keepMonitoring() {
        temperatureMonitoringCenter.standBy();
    }
}

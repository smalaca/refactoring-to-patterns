package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;

public class TemperatureAlerts {
    private final TemperatureMonitoringCenter temperatureMonitoringCenter;

    public TemperatureAlerts(TemperatureMonitoringCenter temperatureMonitoringCenter) {
        this.temperatureMonitoringCenter = temperatureMonitoringCenter;
    }

    public TemperatureControl alerts() {
        return new NoAlert(temperatureMonitoringCenter);
    }
}

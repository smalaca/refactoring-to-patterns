package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring.TemperatureAlerts;

public class AlertCenterFactory {
    public AlertCenter anAlertCenter() {
        return new AlertCenter(new TemperatureAlerts().alerts());
    }
}

package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring.TemperatureAlerts;

public class AlertCenterFactory {
    private final TemperatureMonitoringCenter temperatureMonitoringCenter;
    private final Thermostat thermostat;
    private final Shop shop;
    private final Fridge fridge;
    private final Fan fan;

    public AlertCenterFactory(
            TemperatureMonitoringCenter temperatureMonitoringCenter, Thermostat thermostat, Shop shop, Fridge fridge, Fan fan) {
        this.temperatureMonitoringCenter = temperatureMonitoringCenter;
        this.thermostat = thermostat;
        this.shop = shop;
        this.fridge = fridge;
        this.fan = fan;
    }

    public AlertCenter anAlertCenter() {
        return new AlertCenter(new TemperatureAlerts(temperatureMonitoringCenter, thermostat, shop, fridge, fan).alerts());
    }
}

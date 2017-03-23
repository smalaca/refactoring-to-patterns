package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring.TemperatureAlerts;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring.TemperatureControl;

class AlertCenter {
    private final TemperatureControl temperatureControl;

    AlertCenter(TemperatureMonitoringCenter temperatureMonitoringCenter, Thermostat thermostat, Shop shop, Fridge fridge, Fan fan) {
        temperatureControl = new TemperatureAlerts(temperatureMonitoringCenter, thermostat, shop, fridge, fan).alerts();
    }

    void verify(Temperature temperature) {
        temperatureControl.reactOn(temperature);
    }
}

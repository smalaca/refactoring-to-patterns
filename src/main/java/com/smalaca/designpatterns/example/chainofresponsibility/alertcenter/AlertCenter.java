package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Products;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring.TemperatureAlerts;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring.TemperatureControl;

import static com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Order.anOrder;

class AlertCenter {
    private static final Temperature TOO_LOW_TEMPERATURE = new Temperature(-30);

    private final Thermostat thermostat;
    private final Shop shop;
    private final TemperatureControl temperatureControl;

    AlertCenter(TemperatureMonitoringCenter temperatureMonitoringCenter, Thermostat thermostat, Shop shop, Fridge fridge, Fan fan) {
        this.thermostat = thermostat;
        this.shop = shop;

        temperatureControl = new TemperatureAlerts(temperatureMonitoringCenter, shop, fridge, fan).alerts();
    }

    void verify(Temperature temperature) {
        if (temperature.lowerThan(TOO_LOW_TEMPERATURE)) {
            increaseHeating();
            orderLotOfHotTee();
        } else {
            temperatureControl.reactOn(temperature);
        }
    }

    private void increaseHeating() {
        thermostat.increaseTemperature();
    }

    private void orderLotOfHotTee() {
        shop.order(anOrder(Products.TEE));
    }
}

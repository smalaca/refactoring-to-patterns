package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Products;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;

import static com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Order.anOrder;

class AlertCenter {
    private static final Temperature TOO_HIGH_TEMPERATURE = new Temperature(40);
    private static final Temperature TOO_LOW_TEMPERATURE = new Temperature(-30);

    private final TemperatureMonitoringCenter temperatureMonitoringCenter;
    private final Thermostat thermostat;
    private final Shop shop;
    private final Fridge fridge;
    private final Fan fan;

    AlertCenter(TemperatureMonitoringCenter temperatureMonitoringCenter, Thermostat thermostat, Shop shop, Fridge fridge, Fan fan) {
        this.temperatureMonitoringCenter = temperatureMonitoringCenter;
        this.thermostat = thermostat;
        this.shop = shop;
        this.fridge = fridge;
        this.fan = fan;
    }

    void verify(Temperature temperature) {
        if (temperature.lowerThan(TOO_LOW_TEMPERATURE)) {
            increaseHeating();
            orderLotOfHotTee();
        } else if (temperature.higherThan(TOO_HIGH_TEMPERATURE)) {
            turnOnFan();
            startProduceIce();
            orderSomethingColdToDrink();
        } else {
            keepMonitoring();;
        }
    }

    private void increaseHeating() {
        thermostat.increaseTemperature();
    }

    private void orderLotOfHotTee() {
        shop.order(anOrder(Products.TEE));
    }

    private void orderSomethingColdToDrink() {
        shop.order(anOrder(Products.COKE));
    }

    private void startProduceIce() {
        fridge.produceIce();
    }

    private void turnOnFan() {
        fan.turnOn();
    }

    private void keepMonitoring() {
        temperatureMonitoringCenter.standBy();
    }
}

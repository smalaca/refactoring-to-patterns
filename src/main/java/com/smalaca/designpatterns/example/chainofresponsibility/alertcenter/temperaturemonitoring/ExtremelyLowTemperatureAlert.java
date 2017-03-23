package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Products;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;

import static com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Order.anOrder;

class ExtremelyLowTemperatureAlert implements TemperatureControl {
    private final Thermostat thermostat;
    private final Shop shop;
    private final Temperature tooLowTemperature;
    private final TemperatureControl next;

    ExtremelyLowTemperatureAlert(Thermostat thermostat, Shop shop, Temperature tooLowTemperature, TemperatureControl next) {
        this.thermostat = thermostat;
        this.shop = shop;
        this.tooLowTemperature = tooLowTemperature;
        this.next = next;
    }

    @Override
    public void reactOn(Temperature temperature) {
        if (temperature.lowerThan(tooLowTemperature)) {
            increaseHeating();
            orderLotOfHotTee();
        } else {
            next.reactOn(temperature);
        }
    }

    private void increaseHeating() {
        thermostat.increaseTemperator();
    }

    private void orderLotOfHotTee() {
        shop.order(anOrder(Products.TEE));
    }
}

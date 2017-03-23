package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Products;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;

import static com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Order.anOrder;

class ExtremelyHighTemperatureAlert implements TemperatureControl {
    private final Shop shop;
    private final Fridge fridge;
    private final Fan fan;
    private final Temperature tooHighTemperature;
    private final TemperatureControl next;

    ExtremelyHighTemperatureAlert(Shop shop, Fridge fridge, Fan fan, Temperature tooHighTemperature, TemperatureControl next) {
        this.shop = shop;
        this.fridge = fridge;
        this.fan = fan;
        this.tooHighTemperature = tooHighTemperature;
        this.next = next;
    }

    @Override
    public void reactOn(Temperature temperature) {
        if (temperature.higherThan(tooHighTemperature)) {
            turnOnFan();
            startProduceIce();
            orderSomethingColdToDrink();
        } else {
            next.reactOn(temperature);
        }
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
}

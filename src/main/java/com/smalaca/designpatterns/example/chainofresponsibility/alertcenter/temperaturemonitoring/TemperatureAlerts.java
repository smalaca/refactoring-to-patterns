package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;

public class TemperatureAlerts {
    private static final Temperature TOO_HIGH_TEMPERATURE = new Temperature(40);

    private final TemperatureMonitoringCenter temperatureMonitoringCenter;
    private final Shop shop;
    private final Fridge fridge;
    private final Fan fan;

    public TemperatureAlerts(TemperatureMonitoringCenter temperatureMonitoringCenter, Shop shop, Fridge fridge, Fan fan) {
        this.temperatureMonitoringCenter = temperatureMonitoringCenter;
        this.shop = shop;
        this.fridge = fridge;
        this.fan = fan;
    }

    public TemperatureControl alerts() {
        return new ExtremelyHighTemperatureAlert(shop, fridge, fan, TOO_HIGH_TEMPERATURE,
                new NoAlert(temperatureMonitoringCenter)
        );
    }
}

package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;

public class TemperatureAlerts {
    private static final Temperature TOO_HIGH_TEMPERATURE = new Temperature(40);
    private static final Temperature TOO_LOW_TEMPERATURE = new Temperature(-30);

    private final TemperatureMonitoringCenter temperatureMonitoringCenter;
    private final Thermostat thermostat;
    private final Shop shop;
    private final Fridge fridge;
    private final Fan fan;

    public TemperatureAlerts(TemperatureMonitoringCenter temperatureMonitoringCenter, Thermostat thermostat, Shop shop, Fridge fridge, Fan fan) {
        this.temperatureMonitoringCenter = temperatureMonitoringCenter;
        this.thermostat = thermostat;
        this.shop = shop;
        this.fridge = fridge;
        this.fan = fan;
    }

    public TemperatureControl alerts() {
        return new ExtremelyLowTemperatureAlert(thermostat, shop, TOO_LOW_TEMPERATURE,
                new ExtremelyHighTemperatureAlert(shop, fridge, fan, TOO_HIGH_TEMPERATURE,
                        new NoAlert(temperatureMonitoringCenter)
                )
        );
    }
}

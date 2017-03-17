package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;

public class TemperatureAlerts {
    private static final Temperature TOO_HIGH_TEMPERATURE = new Temperature(40);
    private static final Temperature TOO_LOW_TEMPERATURE = new Temperature(-30);

    public TemperatureControl alerts() {
        return new ExtremelyLowTemperatureAlert(TOO_LOW_TEMPERATURE,
                new ExtremelyHighTemperatureAlert(TOO_HIGH_TEMPERATURE,
                        new NoAlert()
                )
        );
    }
}

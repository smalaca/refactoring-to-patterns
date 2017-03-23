package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AlertCenterTest {
    @Mock private TemperatureMonitoringCenter temperatureMonitoringCenter;
    @Mock private Thermostat thermostat;
    @Mock private Shop shop;
    @Mock private Fridge fridge;
    @Mock private Fan fan;

    private AlertCenter alertCenter;

    @Before
    public void initAlertCenter() {
        alertCenter = new AlertCenter(temperatureMonitoringCenter, thermostat, shop, fridge, fan);
    }

    @Test
    public void shouldRecognizeTooHighTemperature() {


    }

    @Test
    public void shouldRecognizeTooLowTemperature() {


    }

    @Test
    public void shouldRecognizeAppropriateTemperature() {


    }
}
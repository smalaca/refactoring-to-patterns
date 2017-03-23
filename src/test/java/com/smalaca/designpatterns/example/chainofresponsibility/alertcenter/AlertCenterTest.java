package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fan;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Fridge;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.home.Thermostat;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.monitoring.TemperatureMonitoringCenter;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Order;
import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Shop;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Products.COKE;
import static com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.shop.Products.TEE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class AlertCenterTest {
    @Mock private TemperatureMonitoringCenter temperatureMonitoringCenter;
    @Mock private Thermostat thermostat;
    @Mock private Shop shop;
    @Mock private Fridge fridge;
    @Mock private Fan fan;

    @Captor private ArgumentCaptor<Order> orderCaptor;

    private AlertCenter alertCenter;

    @Before
    public void initAlertCenter() {
        alertCenter = new AlertCenterFactory(temperatureMonitoringCenter, thermostat, shop, fridge, fan).anAlertCenter();
    }

    @Test
    public void shouldRecognizeTooHighTemperature() {
        alertCenter.verify(tooHighTemperature());

        then(fan).should().turnOn();
        then(fridge).should().produceIce();
        then(shop).should().order(orderCaptor.capture());
        assertThat(orderCaptor.getValue().getProduct()).isEqualTo(COKE);
    }

    private Temperature tooHighTemperature() {
        return aTemperature(41);
    }

    @Test
    public void shouldRecognizeTooLowTemperature() {
        alertCenter.verify(tooLowTemperature());

        then(thermostat).should().increaseTemperature();
        then(shop).should().order(orderCaptor.capture());
        assertThat(orderCaptor.getValue().getProduct()).isEqualTo(TEE);
    }

    private Temperature tooLowTemperature() {
        return aTemperature(-31);
    }

    @Test
    public void shouldRecognizeAppropriateTemperature() {
        alertCenter.verify(appropriateTemperature());

        then(temperatureMonitoringCenter).should().standBy();
    }

    private Temperature appropriateTemperature() {
        return aTemperature(13);
    }

    private Temperature aTemperature(int temperature) {
        return new Temperature(temperature);
    }
}

package com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.temperaturemonitoring;

import com.smalaca.designpatterns.example.chainofresponsibility.alertcenter.domain.Temperature;

class NoAlert implements TemperatureControl {
    @Override
    public void reactOn(Temperature temperature) {
        nothingToBeScaryAbout();
    }

    private void nothingToBeScaryAbout() {

    }
}

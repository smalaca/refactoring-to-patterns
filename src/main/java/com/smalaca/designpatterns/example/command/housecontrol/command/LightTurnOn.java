package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Light;

class LightTurnOn implements Command {
    private final Light light;

    LightTurnOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

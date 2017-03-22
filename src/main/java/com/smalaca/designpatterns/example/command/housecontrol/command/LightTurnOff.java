package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Light;

class LightTurnOff implements Command {
    private final Light light;

    LightTurnOff(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Light;

class DarkenLight implements Command {
    private final Light light;

    DarkenLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.darken();
    }
}

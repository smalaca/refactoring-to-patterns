package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Fan;
import com.smalaca.designpatterns.example.command.housecontrol.domain.Light;

public class Commands {
    public Command fanSwitchOn(Fan fan) {
        return new FanSwitchOn(fan);
    }

    public Command fanSwitchOff(Fan fan) {
        return new FanSwitchOff(fan);
    }

    public Command fanReducePower(Fan fan) {
        return new FanReducePower(fan);
    }

    public Command fanIncreasePower(Fan fan) {
        return new FanIncreasePower(fan);
    }

    public Command lightTurnOn(Light light) {
        return new LightTurnOn(light);
    }

    public Command darkenLight(Light light) {
        return new DarkenLight(light);
    }

    public Command lightTurnOff(Light light) {
        return new LightTurnOff(light);
    }
}

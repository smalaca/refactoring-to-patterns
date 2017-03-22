package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Fan;

class FanIncreasePower implements Command {
    private final Fan fan;

    FanIncreasePower(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.increasePower();
    }
}

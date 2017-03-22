package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Fan;

class FanReducePower implements Command {
    private final Fan fan;

    FanReducePower(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.reducePower();
    }
}

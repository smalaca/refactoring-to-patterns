package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Fan;

class FanSwitchOn implements Command {
    private final Fan fan;

    FanSwitchOn(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.switchOn();
    }
}

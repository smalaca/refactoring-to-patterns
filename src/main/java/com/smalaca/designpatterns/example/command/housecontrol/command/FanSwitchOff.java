package com.smalaca.designpatterns.example.command.housecontrol.command;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Fan;

class FanSwitchOff implements Command {
    private final Fan fan;

    FanSwitchOff(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.switchOff();
    }
}

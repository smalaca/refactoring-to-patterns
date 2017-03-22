package com.smalaca.designpatterns.example.command.housecontrol.domain;

public interface Fan {
    void switchOn();
    void switchOff();
    void reducePower();
    void increasePower();
}

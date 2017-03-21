package com.smalaca.designpatterns.example.state.day.domain;

class Day {
    private DayPart dayPart;

    void moveForward() {
        dayPart = dayPart.next();
    }
}

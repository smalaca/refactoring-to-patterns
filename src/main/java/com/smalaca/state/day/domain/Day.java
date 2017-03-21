package com.smalaca.state.day.domain;

class Day {
    private DayPart dayPart;

    void moveForward() {
        dayPart = dayPart.next();
    }
}

package com.smalaca.state.day;

class Day {
    private DayPart dayPart;

    void moveForward() {
        dayPart = dayPart.next();
    }
}

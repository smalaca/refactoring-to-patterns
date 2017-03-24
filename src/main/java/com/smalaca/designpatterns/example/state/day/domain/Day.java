package com.smalaca.designpatterns.example.state.day.domain;

import static com.smalaca.designpatterns.example.state.day.domain.DayPart.DAYTIME;
import static com.smalaca.designpatterns.example.state.day.domain.DayPart.EVENING;
import static com.smalaca.designpatterns.example.state.day.domain.DayPart.MORNING;
import static com.smalaca.designpatterns.example.state.day.domain.DayPart.NIGHTTIME;

class Day {
    private DayPart dayPart;

    void moveForward() {
        dayPart = aNextDayPart();
    }

    private DayPart aNextDayPart() {
        if (MORNING.equals(dayPart)) {
            return DAYTIME;
        } else if (DAYTIME.equals(dayPart)) {
            return EVENING;
        } else if (EVENING.equals(dayPart)) {
            return NIGHTTIME;
        } else if (NIGHTTIME.equals(dayPart)) {
            return MORNING;
        } else {
            throw new UnsupportedDayPartException();
        }
    }
}

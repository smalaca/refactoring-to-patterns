package com.smalaca.designpatterns.example.state.day.domain;

enum DayPart {
    MORNING {
        @Override
        DayPart next() {
            return DAYTIME;
        }
    },
    DAYTIME {
        @Override
        DayPart next() {
            return EVENING;
        }
    },
    EVENING {
        @Override
        DayPart next() {
            return NIGHTIME;
        }
    },
    NIGHTIME {
        @Override
        DayPart next() {
            return MORNING;
        }
    };

    abstract DayPart next();
}

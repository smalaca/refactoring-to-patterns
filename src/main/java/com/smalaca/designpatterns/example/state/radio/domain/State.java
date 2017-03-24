package com.smalaca.designpatterns.example.state.radio.domain;

enum State {
    STAND_BY {
        @Override
        void play(Radio radio) {
            if (radio.hasLastPlayedRadioStation()) {
                radio.startWithLastPlayed();
            } else {
                radio.startWith(RadioStations.random());
            }
            radio.changeStateTo(PLAYING);
        }
    },
    PLAYING {
        @Override
        void play(Radio radio) {
            radio.rememberPlayedRadioStation();
            radio.stop();
            radio.changeStateTo(STAND_BY);
        }
    };

    abstract void play(Radio radio);
}

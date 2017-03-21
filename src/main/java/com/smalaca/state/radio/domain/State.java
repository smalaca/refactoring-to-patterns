package com.smalaca.state.radio.domain;

enum State {
    STAND_BY {
        @Override
        void play(Radio radio) {
            if (radio.hasLastPlayedRadioStation()) {
                radio.startWithLastPlayed();
            } else {
                radio.startWith(RadioStations.random());
            }
            radio.setState(PLAYING);
        }
    },
    PLAYING {
        @Override
        void play(Radio radio) {
            radio.rememberPlayedRadioStation();
            radio.stop();
            radio.setState(STAND_BY);
        }
    };

    abstract void play(Radio radio);
}

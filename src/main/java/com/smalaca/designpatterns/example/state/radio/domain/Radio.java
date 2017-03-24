package com.smalaca.designpatterns.example.state.radio.domain;

import static com.smalaca.designpatterns.example.state.radio.domain.State.PLAYING;
import static com.smalaca.designpatterns.example.state.radio.domain.State.STAND_BY;

public class Radio {
    private State state;
    private RadioStation lastPlayed;
    private RadioStation playing;

    public void play() {
        switch (state) {
            case STAND_BY:
                if (hasLastPlayedRadioStation()) {
                    startWithLastPlayed();
                } else {
                    startWith(RadioStations.random());
                }

                changeStateTo(PLAYING);
                break;

            case PLAYING:
                rememberPlayedRadioStation();
                stop();
                changeStateTo(STAND_BY);
                break;
        }
    }

    private void changeStateTo(State state) {
        this.state = state;
    }

    private void startWith(RadioStation radioStation) {

    }

    private void startWithLastPlayed() {
        playing = lastPlayed;
    }

    private void rememberPlayedRadioStation() {
        lastPlayed = playing;
    }

    private void stop() {
        playing = null;
    }

    private boolean hasLastPlayedRadioStation() {
        return lastPlayed != null;
    }
}

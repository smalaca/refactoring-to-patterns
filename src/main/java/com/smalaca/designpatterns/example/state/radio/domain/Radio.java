package com.smalaca.designpatterns.example.state.radio.domain;

public class Radio {
    private State state;
    private RadioStation lastPlayed;
    private RadioStation playing;

    public void play() {
        state.play(this);
    }

    void changeStateTo(State state) {
        this.state = state;
    }

    void startWith(RadioStation radioStation) {

    }

    void startWithLastPlayed() {
        playing = lastPlayed;
    }

    void rememberPlayedRadioStation() {
        lastPlayed = playing;
    }

    void stop() {
        playing = null;
    }

    boolean hasLastPlayedRadioStation() {
        return lastPlayed != null;
    }
}

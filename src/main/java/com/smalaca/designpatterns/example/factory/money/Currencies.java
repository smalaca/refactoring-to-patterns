package com.smalaca.designpatterns.example.factory.money;

public class Currencies {
    public Currency pln() {
        return new Pln();
    }

    public Currency usd() {
        return new Usd();
    }

    public Currency euro() {
        return new Euro();
    }
}

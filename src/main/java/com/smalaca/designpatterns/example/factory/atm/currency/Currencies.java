package com.smalaca.designpatterns.example.factory.atm.currency;

public class Currencies {
    public static Currency pln(int amount) {
        return new Pln(amount);
    }

    public static Currency usd(int amount) {
        return new Usd(amount);
    }

    public static Currency euro(int amount) {
        return new Euro(amount);
    }
}

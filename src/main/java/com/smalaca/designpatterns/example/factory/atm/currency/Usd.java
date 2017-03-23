package com.smalaca.designpatterns.example.factory.atm.currency;

class Usd implements Currency {
    private final int amount;

    Usd(int amount) {
        this.amount = amount;
    }
}

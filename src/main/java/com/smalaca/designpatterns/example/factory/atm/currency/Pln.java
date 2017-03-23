package com.smalaca.designpatterns.example.factory.atm.currency;

class Pln implements Currency {
    private final int amount;

    Pln(int amount) {
        this.amount = amount;
    }
}

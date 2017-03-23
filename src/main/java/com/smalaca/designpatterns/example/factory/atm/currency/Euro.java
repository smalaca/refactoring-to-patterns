package com.smalaca.designpatterns.example.factory.atm.currency;

class Euro implements Currency {
    private final int amount;

    Euro(int amount) {
        this.amount = amount;
    }
}

package com.smalaca.designpatterns.example.factory.atm;

import com.smalaca.designpatterns.example.factory.atm.currency.Euro;
import com.smalaca.designpatterns.example.factory.atm.currency.Pln;
import com.smalaca.designpatterns.example.factory.atm.currency.Usd;

class Atm {
    Euro withdrawEuro(int amount) {
        checkBalanceFor(amount);
        Euro euro = new Euro(amount);
        return withdraw(euro);
    }

    private Euro withdraw(Euro euro) {
        return null;
    }

    Pln withdrawPln(int amount) {
        checkBalanceFor(amount);
        Pln pln = new Pln(amount);
        return withdraw(pln);
    }

    private Pln withdraw(Pln pln) {
        return null;
    }

    Usd withdrawUsd(int amount) {
        checkBalanceFor(amount);
        Usd usd = new Usd(amount);
        return withdraw(usd);
    }

    private Usd withdraw(Usd usd) {
        return null;
    }

    private void checkBalanceFor(int amount) {

    }
}

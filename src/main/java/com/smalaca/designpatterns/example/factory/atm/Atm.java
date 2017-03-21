package com.smalaca.designpatterns.example.factory.atm;

import com.smalaca.designpatterns.example.factory.atm.currency.Currency;

import static com.smalaca.designpatterns.example.factory.atm.currency.Currencies.euro;
import static com.smalaca.designpatterns.example.factory.atm.currency.Currencies.pln;
import static com.smalaca.designpatterns.example.factory.atm.currency.Currencies.usd;

class Atm {
    Currency withdrawEuro(int amount) {
        checkBalanceFor(amount);
        Currency euro = euro(amount);
        return withdraw(euro);
    }

    Currency withdrawPln(int amount) {
        checkBalanceFor(amount);
        Currency pln = pln(amount);
        return withdraw(pln);
    }

    Currency withdrawUsd(int amount) {
        checkBalanceFor(amount);
        Currency usd = usd(amount);
        return withdraw(usd);
    }

    private void checkBalanceFor(int amount) {

    }

    private Currency withdraw(Currency usd) {
        return null;
    }
}

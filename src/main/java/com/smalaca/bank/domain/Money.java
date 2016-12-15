package com.smalaca.bank.domain;

public class Money {
    private final double amount;

    Money(double amount) {
        this.amount = amount;
    }

    public Money add(Money money) {
        return new Money(amount + money.amount);
    }

    public Money sub(Money money) {
        return new Money(amount - money.amount);
    }

    public boolean empty() {
        return false;
    }

    public double getAmount() {
        return amount;
    }
}

package com.smalaca.bank.domain;

import com.smalaca.bank.exception.UnsupportedOperationOnAccountException;

class Account {
    private Money debit;
    private Money money;
    private Money blocked;
    private Client client;
    private ClientType clientType;
    private final AccountNumber accountNumber;

    Account(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    Money withdrawAndGetBalance(Money money) {
        money = getMoney().sub(money);
        return getBalance();
    }

    Money getBalance() {
        Money temp = getDebit().add(getMoney());
        temp = temp.sub(getBlocked());

        return temp;
    }

    boolean hasAvailableMoney() {
        if (getMoney().empty()) {
            return false;
        }

        if (getBlocked() != null || getMoney().sub(getBlocked()).empty()) {
            return false;
        }

        return true;
    }

    void doOperation(String operation, Money money) {
        if ("withdraw".equals(operation)) {
            money = getMoney().sub(money);
        } else if ("deposit".equals(operation)) {
            money = getMoney().add(money);
        } else {
            throw new UnsupportedOperationOnAccountException();
        }
    }

    Money getDebit() {
        return debit;
    }

    Money getMoney() {
        return money;
    }

    Money getBlocked() {
        return blocked;
    }
}

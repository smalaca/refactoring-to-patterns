package com.smalaca.bank.domain;

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

    Money getBalance() {
        Money temp = getDebit().add(getMoney());
        temp = temp.sub(getBlocked());

        return temp;
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

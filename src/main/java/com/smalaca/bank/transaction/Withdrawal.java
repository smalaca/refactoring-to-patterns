package com.smalaca.bank.transaction;

import com.smalaca.bank.domain.AccountNumber;
import com.smalaca.bank.domain.Money;
import com.smalaca.bank.event.WithdrawalEvent;
import com.smalaca.bank.transaction.repository.TransactionRepository;

class Withdrawal {
    private final TransactionRepository transactionRepository;

    Withdrawal(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    void withdraw(Money availableMoney, Money withdrawal, AccountNumber accountNumber) {
        availableMoney = availableMoney.add(withdrawal);

        transactionRepository.submit(new WithdrawalEvent(accountNumber, availableMoney));
    }
}

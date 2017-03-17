package com.smalaca.refactoring.patterns.bank.transaction;

import com.smalaca.refactoring.patterns.bank.domain.AccountNumber;
import com.smalaca.refactoring.patterns.bank.domain.Money;
import com.smalaca.refactoring.patterns.bank.event.WithdrawalEvent;
import com.smalaca.refactoring.patterns.bank.transaction.repository.TransactionRepository;

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

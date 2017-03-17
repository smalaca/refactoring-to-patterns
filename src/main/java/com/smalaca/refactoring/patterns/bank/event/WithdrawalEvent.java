package com.smalaca.refactoring.patterns.bank.event;

import com.smalaca.refactoring.patterns.bank.domain.AccountNumber;
import com.smalaca.refactoring.patterns.bank.domain.Money;

public class WithdrawalEvent {
    public WithdrawalEvent(AccountNumber accountNumber, Money availableMoney) {

    }
}

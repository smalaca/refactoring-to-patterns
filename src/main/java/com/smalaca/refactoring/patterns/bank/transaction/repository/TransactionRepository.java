package com.smalaca.refactoring.patterns.bank.transaction.repository;

import com.smalaca.refactoring.patterns.bank.event.AnalyzeRequestEvent;
import com.smalaca.refactoring.patterns.bank.event.WithdrawalEvent;

public interface TransactionRepository {
    void submit(WithdrawalEvent withdrawalEvent);

    void submit(AnalyzeRequestEvent analyzeRequestEvent);
}

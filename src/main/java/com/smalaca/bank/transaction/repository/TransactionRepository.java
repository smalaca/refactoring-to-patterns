package com.smalaca.bank.transaction.repository;

import com.smalaca.bank.event.AnalyzeRequestEvent;
import com.smalaca.bank.event.WithdrawalEvent;

public interface TransactionRepository {
    void submit(WithdrawalEvent withdrawalEvent);

    void submit(AnalyzeRequestEvent analyzeRequestEvent);
}

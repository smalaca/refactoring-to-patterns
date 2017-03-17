package com.smalaca.refactoring.patterns.bank.transaction;

import com.smalaca.refactoring.patterns.bank.domain.Client;
import com.smalaca.refactoring.patterns.bank.domain.Money;
import com.smalaca.refactoring.patterns.bank.event.AnalyzeRequestEvent;
import com.smalaca.refactoring.patterns.bank.transaction.repository.TransactionRepository;

class CalculateCreditRisk {
    private final TransactionRepository transactionRepository;

    CalculateCreditRisk(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    void calculateRiskFor(Client client, Money money) {
        if (client.isNewClient()) {
            double riskIndicator = money.getAmount() * 0.69;
            transactionRepository.submit(new AnalyzeRequestEvent(riskIndicator, money));
        } else {
            double riskIndicator = money.getAmount() * 0.13;
            transactionRepository.submit(new AnalyzeRequestEvent(riskIndicator, money));
        }
    }
}

package com.smalaca.bank.transaction;

import com.smalaca.bank.domain.Client;
import com.smalaca.bank.domain.Money;
import com.smalaca.bank.event.AnalyzeRequestEvent;
import com.smalaca.bank.transaction.repository.TransactionRepository;

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

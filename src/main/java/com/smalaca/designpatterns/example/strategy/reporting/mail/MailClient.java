package com.smalaca.designpatterns.example.strategy.reporting.mail;

import com.smalaca.designpatterns.example.strategy.reporting.domain.Message;

public interface MailClient {
    void send(Message message);
}

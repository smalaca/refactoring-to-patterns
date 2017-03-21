package com.smalaca.designpatterns.example.strategy.message.mail;

import com.smalaca.designpatterns.example.strategy.message.domain.Message;

public interface MailClient {
    void send(Message message);
}

package com.smalaca.designpatterns.example.visitor.message.send;

import com.smalaca.designpatterns.example.visitor.message.domain.Message;
import com.smalaca.designpatterns.example.visitor.message.domain.repository.MessageRepository;

public class Messanger {
    private final MessageSender messageSender;
    private final MessageRepository messageRepository;

    public Messanger(MessageSender messageSender, MessageRepository messageRepository) {
        this.messageSender = messageSender;
        this.messageRepository = messageRepository;
    }

    void send(Message message) {
        message.accept(messageSender);
        messageRepository.store(message);
    }
}

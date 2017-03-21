package com.smalaca.designpatterns.example.visitor.message.domain.repository;

import com.smalaca.designpatterns.example.visitor.message.domain.Message;

public interface MessageRepository {
    void store(Message message);
}

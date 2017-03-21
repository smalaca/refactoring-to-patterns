package com.smalaca.designpatterns.example.visitor.message.domain;

import com.smalaca.designpatterns.example.visitor.message.send.visitor.Visitor;

public interface Message {
    void accept(Visitor visitor);
}

package com.smalaca.designpatterns.example.visitor.message.domain;

import com.smalaca.designpatterns.example.visitor.message.send.visitor.Visitor;

public class Email implements Message {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

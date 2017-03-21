package com.smalaca.designpatterns.example.visitor.message.domain;

import com.smalaca.designpatterns.example.visitor.message.send.visitor.Visitor;

public class Tweet implements Message {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

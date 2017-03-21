package com.smalaca.designpatterns.example.visitor.message.send.visitor;

import com.smalaca.designpatterns.example.visitor.message.domain.Email;
import com.smalaca.designpatterns.example.visitor.message.domain.Sms;
import com.smalaca.designpatterns.example.visitor.message.domain.Tweet;

public interface Visitor {
    void visit(Email email);

    void visit(Tweet tweet);

    void visit(Sms sms);
}

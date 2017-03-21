package com.smalaca.designpatterns.example.visitor.message.send;

import com.smalaca.designpatterns.example.visitor.message.domain.Email;
import com.smalaca.designpatterns.example.visitor.message.domain.Sms;
import com.smalaca.designpatterns.example.visitor.message.domain.Tweet;
import com.smalaca.designpatterns.example.visitor.message.send.visitor.Visitor;

class MessageSender implements Visitor {
    @Override
    public void visit(Email email) {
        sendAnEmail(email);
    }

    private void sendAnEmail(Email email) {

    }

    @Override
    public void visit(Tweet tweet) {
        sendTweet(tweet);
    }

    private void sendTweet(Tweet tweet) {

    }

    @Override
    public void visit(Sms sms) {
        sendSms(sms);
    }

    private void sendSms(Sms sms) {

    }
}

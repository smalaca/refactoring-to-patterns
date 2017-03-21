package com.smalaca.designpatterns.example.visitor.message.statistics;

import com.smalaca.designpatterns.example.visitor.message.domain.Email;
import com.smalaca.designpatterns.example.visitor.message.domain.Sms;
import com.smalaca.designpatterns.example.visitor.message.domain.Statistic;
import com.smalaca.designpatterns.example.visitor.message.domain.Tweet;
import com.smalaca.designpatterns.example.visitor.message.send.visitor.Visitor;

class StatisticsAnalyzer implements Visitor {
    @Override
    public void visit(Email email) {
        gatherFromEmail(email);
    }

    private void gatherFromEmail(Email email) {

    }

    @Override
    public void visit(Tweet tweet) {
        gatherFromTweet(tweet);
    }

    private void gatherFromTweet(Tweet tweet) {

    }

    @Override
    public void visit(Sms sms) {
        gatherFromSms(sms);
    }

    private void gatherFromSms(Sms sms) {

    }

    Statistic getLast() {
        return null;
    }
}

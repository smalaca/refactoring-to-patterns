package com.smalaca.designpatterns.example.strategy.message.domain;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private final Receiver receiver;
    private final List<Report> reports = new ArrayList<>();

    public Message(Receiver receiver) {
        this.receiver = receiver;
    }

    public void attach(Report report) {
        reports.add(report);
    }
}

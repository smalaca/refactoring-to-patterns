package com.smalaca.designpatterns.example.strategy.message.domain;

public interface Request {
    ReportType reportType();

    Receiver receiver();

    InputData data();
}

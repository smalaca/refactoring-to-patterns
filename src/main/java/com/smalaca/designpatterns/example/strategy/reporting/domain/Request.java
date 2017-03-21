package com.smalaca.designpatterns.example.strategy.reporting.domain;

public interface Request {
    ReportType reportType();

    Receiver receiver();

    InputData data();
}

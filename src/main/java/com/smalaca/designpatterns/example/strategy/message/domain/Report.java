package com.smalaca.designpatterns.example.strategy.message.domain;

public interface Report {
    void addHeader(ReportHeader reportHeader);

    void addData(InputData inputData);

    void addFooter(ReportFooter reportFooter);
}

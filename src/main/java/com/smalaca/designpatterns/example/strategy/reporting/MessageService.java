package com.smalaca.designpatterns.example.strategy.reporting;

import com.smalaca.designpatterns.example.strategy.reporting.domain.ReportType;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Request;
import com.smalaca.designpatterns.example.strategy.reporting.report.generator.ReportGenerator;
import com.smalaca.designpatterns.example.strategy.reporting.report.generator.ReportGenerators;

import java.util.Map;

public class MessageService {
    private final MessageSender messageSender;
    private final Map<ReportType, ReportGenerator> generators;

    public MessageService(MessageSender messageSender, ReportGenerators reportGenerators) {
        this.messageSender = messageSender;
        this.generators = reportGenerators.create();
    }

    public void sendMessage(Request request) {
        messageSender.changeReportGenerator(generators.get(request.reportType()));
        messageSender.generate(request.receiver(), request.data());
    }
}

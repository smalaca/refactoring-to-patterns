package com.smalaca.designpatterns.example.strategy.reporting;

import com.smalaca.designpatterns.example.strategy.reporting.domain.InputData;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Message;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Receiver;
import com.smalaca.designpatterns.example.strategy.reporting.report.generator.ReportGenerator;
import com.smalaca.designpatterns.example.strategy.reporting.mail.MailClient;

class MessageSender {
    private final MailClient mailClient;
    private ReportGenerator reportGenerator;

    public MessageSender(MailClient mailClient, ReportGenerator reportGenerator) {
        this.mailClient = mailClient;
        this.reportGenerator = reportGenerator;
    }

    void changeReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    void generate(Receiver receiver, InputData inputData) {
        Message message = createMessageFor(receiver);
        message.attach(reportGenerator.generateFrom(inputData));;

        mailClient.send(message);
    }

    private Message createMessageFor(Receiver receiver) {
        return new Message(receiver);
    }
}

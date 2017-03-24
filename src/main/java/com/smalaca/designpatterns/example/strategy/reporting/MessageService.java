package com.smalaca.designpatterns.example.strategy.reporting;

import com.smalaca.designpatterns.example.strategy.reporting.domain.CsvReport;
import com.smalaca.designpatterns.example.strategy.reporting.domain.InputData;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Message;
import com.smalaca.designpatterns.example.strategy.reporting.domain.PdfReport;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Receiver;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Report;
import com.smalaca.designpatterns.example.strategy.reporting.domain.ReportFooter;
import com.smalaca.designpatterns.example.strategy.reporting.domain.ReportHeader;
import com.smalaca.designpatterns.example.strategy.reporting.domain.ReportType;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Request;
import com.smalaca.designpatterns.example.strategy.reporting.domain.UnsupportReportTypeException;
import com.smalaca.designpatterns.example.strategy.reporting.domain.XmlReport;
import com.smalaca.designpatterns.example.strategy.reporting.mail.MailClient;

public class MessageService {
    private final MailClient mailClient;

    public MessageService(MailClient mailClient) {
        this.mailClient = mailClient;
    }

    public void sendMessage(Request request) {
        Message message = createMessageFor(request.receiver());
        Report report = aReport(request.reportType(), request.data());
        message.attach(report);

        mailClient.send(message);
    }

    private Message createMessageFor(Receiver receiver) {
        return new Message(receiver);
    }

    private Report aReport(ReportType reportType, InputData inputData) {
        Report report;

        switch (reportType) {
            case CSV:
                report = new CsvReport();
                report.addData(inputData);

                return report;

            case PDF:
                report = new PdfReport();
                report.addHeader(generatePdfHeader());
                report.addData(inputData);
                report.addFooter(generatePdfFooter());

                return report;

            case XML:
                report = new XmlReport();
                report.addHeader(generateXmlHeader());
                report.addData(inputData);
                report.addFooter(generateXmlFooter());

                return report;

            default:
                throw new UnsupportReportTypeException();
        }
    }

    private ReportHeader generatePdfHeader() {
        return null;
    }

    private ReportFooter generatePdfFooter() {
        return null;
    }

    private ReportFooter generateXmlFooter() {
        return null;
    }

    private ReportHeader generateXmlHeader() {
        return null;
    }
}

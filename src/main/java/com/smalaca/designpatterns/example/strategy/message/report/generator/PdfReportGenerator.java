package com.smalaca.designpatterns.example.strategy.message.report.generator;

import com.smalaca.designpatterns.example.strategy.message.domain.InputData;
import com.smalaca.designpatterns.example.strategy.message.domain.PdfReport;
import com.smalaca.designpatterns.example.strategy.message.domain.Report;
import com.smalaca.designpatterns.example.strategy.message.domain.ReportFooter;
import com.smalaca.designpatterns.example.strategy.message.domain.ReportHeader;

class PdfReportGenerator implements ReportGenerator {
    @Override
    public Report generateFrom(InputData inputData) {
        Report report = new PdfReport();
        report.addHeader(generatePdfHeader());
        report.addData(inputData);
        report.addFooter(generatePdfFooter());

        return report;
    }

    private ReportHeader generatePdfHeader() {
        return null;
    }

    private ReportFooter generatePdfFooter() {
        return null;
    }
}

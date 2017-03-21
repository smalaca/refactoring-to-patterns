package com.smalaca.designpatterns.example.strategy.reporting.report.generator;

import com.smalaca.designpatterns.example.strategy.reporting.domain.InputData;
import com.smalaca.designpatterns.example.strategy.reporting.domain.PdfReport;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Report;
import com.smalaca.designpatterns.example.strategy.reporting.domain.ReportFooter;
import com.smalaca.designpatterns.example.strategy.reporting.domain.ReportHeader;

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

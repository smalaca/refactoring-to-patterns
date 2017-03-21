package com.smalaca.designpatterns.example.strategy.message.report.generator;

import com.smalaca.designpatterns.example.strategy.message.domain.InputData;
import com.smalaca.designpatterns.example.strategy.message.domain.Report;
import com.smalaca.designpatterns.example.strategy.message.domain.ReportFooter;
import com.smalaca.designpatterns.example.strategy.message.domain.ReportHeader;
import com.smalaca.designpatterns.example.strategy.message.domain.XmlReport;

class XmlReportGenerator implements ReportGenerator {
    @Override
    public Report generateFrom(InputData inputData) {
        Report report = new XmlReport();
        report.addHeader(generateXmlHeader());
        report.addData(inputData);
        report.addFooter(generateXmlFooter());

        return report;
    }

    private ReportFooter generateXmlFooter() {
        return null;
    }

    private ReportHeader generateXmlHeader() {
        return null;
    }
}

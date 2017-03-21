package com.smalaca.designpatterns.example.strategy.reporting.report.generator;

import com.smalaca.designpatterns.example.strategy.reporting.domain.CsvReport;
import com.smalaca.designpatterns.example.strategy.reporting.domain.InputData;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Report;

class CsvReportGenerator implements ReportGenerator {
    @Override
    public Report generateFrom(InputData inputData) {
        Report report = new CsvReport();
        report.addData(inputData);

        return report;
    }
}

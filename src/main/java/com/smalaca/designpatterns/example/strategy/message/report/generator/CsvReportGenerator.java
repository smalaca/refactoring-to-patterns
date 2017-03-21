package com.smalaca.designpatterns.example.strategy.message.report.generator;

import com.smalaca.designpatterns.example.strategy.message.domain.CsvReport;
import com.smalaca.designpatterns.example.strategy.message.domain.InputData;
import com.smalaca.designpatterns.example.strategy.message.domain.Report;

class CsvReportGenerator implements ReportGenerator {
    @Override
    public Report generateFrom(InputData inputData) {
        Report report = new CsvReport();
        report.addData(inputData);

        return report;
    }
}

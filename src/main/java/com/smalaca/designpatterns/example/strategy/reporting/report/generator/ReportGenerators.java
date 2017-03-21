package com.smalaca.designpatterns.example.strategy.reporting.report.generator;

import com.smalaca.designpatterns.example.strategy.reporting.domain.ReportType;

import java.util.HashMap;
import java.util.Map;

import static com.smalaca.designpatterns.example.strategy.reporting.domain.ReportType.CSV;
import static com.smalaca.designpatterns.example.strategy.reporting.domain.ReportType.PDF;
import static com.smalaca.designpatterns.example.strategy.reporting.domain.ReportType.XML;

public class ReportGenerators {
    public Map<ReportType, ReportGenerator> create() {
        Map<ReportType, ReportGenerator> generators = new HashMap<>();
        generators.put(XML, new XmlReportGenerator());
        generators.put(PDF, new PdfReportGenerator());
        generators.put(CSV, new CsvReportGenerator());
        return generators;
    }
}

package com.smalaca.designpatterns.example.strategy.message.report.generator;

import com.smalaca.designpatterns.example.strategy.message.domain.ReportType;

import java.util.HashMap;
import java.util.Map;

import static com.smalaca.designpatterns.example.strategy.message.domain.ReportType.CSV;
import static com.smalaca.designpatterns.example.strategy.message.domain.ReportType.PDF;
import static com.smalaca.designpatterns.example.strategy.message.domain.ReportType.XML;

public class ReportGenerators {
    public Map<ReportType, ReportGenerator> create() {
        Map<ReportType, ReportGenerator> generators = new HashMap<>();
        generators.put(XML, new XmlReportGenerator());
        generators.put(PDF, new PdfReportGenerator());
        generators.put(CSV, new CsvReportGenerator());
        return generators;
    }
}

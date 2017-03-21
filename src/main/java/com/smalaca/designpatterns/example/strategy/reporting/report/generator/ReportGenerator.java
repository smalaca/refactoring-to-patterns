package com.smalaca.designpatterns.example.strategy.reporting.report.generator;

import com.smalaca.designpatterns.example.strategy.reporting.domain.InputData;
import com.smalaca.designpatterns.example.strategy.reporting.domain.Report;

public interface ReportGenerator {
    Report generateFrom(InputData inputData);
}

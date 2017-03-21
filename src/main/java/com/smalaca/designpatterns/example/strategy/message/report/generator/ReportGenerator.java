package com.smalaca.designpatterns.example.strategy.message.report.generator;

import com.smalaca.designpatterns.example.strategy.message.domain.InputData;
import com.smalaca.designpatterns.example.strategy.message.domain.Report;

public interface ReportGenerator {
    Report generateFrom(InputData inputData);
}

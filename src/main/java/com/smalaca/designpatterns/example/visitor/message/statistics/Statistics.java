package com.smalaca.designpatterns.example.visitor.message.statistics;

import com.smalaca.designpatterns.example.visitor.message.domain.Message;
import com.smalaca.designpatterns.example.visitor.message.domain.Statistic;
import com.smalaca.designpatterns.example.visitor.message.domain.repository.StatisticsRepository;

public class Statistics {
    private final StatisticsRepository statisticsRepository;
    private final StatisticsAnalyzer statisticsAnalyzer;

    public Statistics(StatisticsRepository statisticsRepository, StatisticsAnalyzer statisticsAnalyzer) {
        this.statisticsRepository = statisticsRepository;
        this.statisticsAnalyzer = statisticsAnalyzer;
    }

    void gather(Message message) {
        message.accept(statisticsAnalyzer);
        Statistic statistic = statisticsAnalyzer.getStatistics();
        statisticsRepository.store(statistic);
    }
}

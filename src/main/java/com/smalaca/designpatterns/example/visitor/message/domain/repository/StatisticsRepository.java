package com.smalaca.designpatterns.example.visitor.message.domain.repository;

import com.smalaca.designpatterns.example.visitor.message.domain.Statistic;

public interface StatisticsRepository {
    void store(Statistic statistic);
}

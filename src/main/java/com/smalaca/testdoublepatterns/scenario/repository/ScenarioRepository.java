package com.smalaca.testdoublepatterns.scenario.repository;

import com.smalaca.testdoublepatterns.scenario.domain.Author;
import com.smalaca.testdoublepatterns.scenario.domain.Scenario;

public interface ScenarioRepository {
    void store(Scenario scenario, Author author);
}

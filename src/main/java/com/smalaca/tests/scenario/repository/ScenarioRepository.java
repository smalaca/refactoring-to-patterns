package com.smalaca.tests.scenario.repository;

import com.smalaca.domain.Author;
import com.smalaca.domain.Scenario;

public interface ScenarioRepository {
    void store(Scenario scenario, Author author);
}

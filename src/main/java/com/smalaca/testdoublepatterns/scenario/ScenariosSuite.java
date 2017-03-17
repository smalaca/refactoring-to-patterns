package com.smalaca.testdoublepatterns.scenario;

import com.smalaca.testdoublepatterns.scenario.domain.Author;
import com.smalaca.testdoublepatterns.scenario.domain.Scenario;
import com.smalaca.testdoublepatterns.scenario.externalservice.ExternalScenarioValidator;
import com.smalaca.testdoublepatterns.scenario.repository.ScenarioRepository;

import java.util.List;

class ScenariosSuite {
    private final ScenarioRepository scenarioRepository;
    private final ExternalScenarioValidator scenarioValidator;

    ScenariosSuite(ScenarioRepository scenarioRepository, ExternalScenarioValidator scenarioValidator) {
        this.scenarioRepository = scenarioRepository;
        this.scenarioValidator = scenarioValidator;
    }

    void accept(Scenario scenario, Author author) {
        if (scenarioValidator.isValid(scenario)) {
            scenarioRepository.store(scenario, author);
        }
    }

    void accept(List<Scenario> scenarios, Author author) {
        for (Scenario scenario : scenarios) {
            if (scenarioValidator.isValid(scenario)) {
                scenarioRepository.store(scenario, author);
            }
        }
    }
}

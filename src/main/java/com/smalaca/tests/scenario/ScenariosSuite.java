package com.smalaca.tests.scenario;

import com.smalaca.domain.Author;
import com.smalaca.domain.Scenario;
import com.smalaca.tests.scenario.externalservice.ExternalScenarioValidator;
import com.smalaca.tests.scenario.repository.ScenarioRepository;

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

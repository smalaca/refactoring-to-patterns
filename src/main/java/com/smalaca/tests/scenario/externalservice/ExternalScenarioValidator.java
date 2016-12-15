package com.smalaca.tests.scenario.externalservice;

import com.smalaca.domain.Scenario;

public class ExternalScenarioValidator {
    public boolean isValid(Scenario scenario) {
        return scenario.isMarkedAsCompleted() && scenario.isApproved();
    }
}

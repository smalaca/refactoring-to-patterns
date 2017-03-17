package com.smalaca.testdoublepatterns.scenario.externalservice;

import com.smalaca.testdoublepatterns.scenario.domain.Scenario;

public class ExternalScenarioValidator {
    public boolean isValid(Scenario scenario) {
        return scenario.isMarkedAsCompleted() && scenario.isApproved();
    }
}

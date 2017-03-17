package com.smalaca.testdoublepatterns.scenario.domain;

import static com.smalaca.testdoublepatterns.scenario.domain.SuiteState.COMPLETED;
import static com.smalaca.testdoublepatterns.scenario.domain.SuiteState.CREATED;

public class Scenario {
    private boolean approved = false;
    private SuiteState state = CREATED;

    public boolean isMarkedAsCompleted() {
        return COMPLETED.equals(state);
    }

    public boolean isApproved() {
        return approved;
    }
}

package com.smalaca.domain;

import static com.smalaca.domain.SuiteState.COMPLETED;
import static com.smalaca.domain.SuiteState.CREATED;

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

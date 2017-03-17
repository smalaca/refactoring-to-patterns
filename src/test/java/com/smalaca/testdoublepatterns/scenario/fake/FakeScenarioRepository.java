package com.smalaca.testdoublepatterns.scenario.fake;

import com.smalaca.testdoublepatterns.scenario.domain.Author;
import com.smalaca.testdoublepatterns.scenario.domain.Scenario;
import com.smalaca.testdoublepatterns.scenario.repository.ScenarioRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeScenarioRepository implements ScenarioRepository {
    private final List<Scenario> scenarios = new ArrayList<>();

    @Override
    public void store(Scenario scenario, Author author) {
        scenarios.add(scenario);
    }

    public int scenarionsAmount() {
        return scenarios.size();
    }
}

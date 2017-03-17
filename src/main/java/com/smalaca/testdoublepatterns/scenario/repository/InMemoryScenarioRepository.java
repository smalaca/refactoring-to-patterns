package com.smalaca.testdoublepatterns.scenario.repository;

import com.smalaca.testdoublepatterns.scenario.domain.Author;
import com.smalaca.testdoublepatterns.scenario.domain.Scenario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class InMemoryScenarioRepository implements ScenarioRepository {
    private final Map<Author, List<Scenario>> scenarios = new HashMap<>();

    @Override
    public void store(Scenario scenario, Author author) {
        if (scenarios.containsKey(author)) {
            scenarios.put(author, new ArrayList<>());
        }

        scenarios.get(author).add(scenario);
    }

    public int howManyScenariosFor(Author author) {
        return scenarios.getOrDefault(author, emptyList()).size();
    }
}

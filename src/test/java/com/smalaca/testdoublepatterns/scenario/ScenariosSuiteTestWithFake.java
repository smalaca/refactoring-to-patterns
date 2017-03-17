package com.smalaca.testdoublepatterns.scenario;

import com.smalaca.testdoublepatterns.scenario.domain.Author;
import com.smalaca.testdoublepatterns.scenario.domain.Scenario;
import com.smalaca.testdoublepatterns.scenario.externalservice.ExternalScenarioValidator;
import com.smalaca.testdoublepatterns.scenario.fake.FakeScenarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ScenariosSuiteTestWithFake {
    private static final Scenario DUMMY_SCENARIO = new Scenario();
    private static final Author DUMMY_AUTHOR = new Author();

    private FakeScenarioRepository scenarioRepository = new FakeScenarioRepository();
    @Mock private ExternalScenarioValidator scenarioValidator;
    private ScenariosSuite scenariosSuite;

    @Before
    public void init() {
        scenariosSuite = new ScenariosSuite(scenarioRepository, scenarioValidator);
    }

    @Test
    public void shouldStoreValidScenario() {
        givenValidScenario();

        scenariosSuite.accept(DUMMY_SCENARIO, DUMMY_AUTHOR);

        assertThat(scenarioRepository.scenarionsAmount()).isEqualTo(1);
    }

    private void givenValidScenario() {
        given(scenarioValidator.isValid(any())).willReturn(true);
    }

    @Test
    public void shouldNotStoreInValidScenario() {
        givenInvalidScenario();

        scenariosSuite.accept(DUMMY_SCENARIO, DUMMY_AUTHOR);

        assertThat(scenarioRepository.scenarionsAmount()).isEqualTo(0);
    }

    private void givenInvalidScenario() {
        given(scenarioValidator.isValid(any())).willReturn(false);
    }
}

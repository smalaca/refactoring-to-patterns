package com.smalaca.testdoublepatterns.scenario;

import com.smalaca.testdoublepatterns.scenario.domain.Author;
import com.smalaca.testdoublepatterns.scenario.domain.Scenario;
import com.smalaca.testdoublepatterns.scenario.externalservice.ExternalScenarioValidator;
import com.smalaca.testdoublepatterns.scenario.repository.InMemoryScenarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class ScenariosSuiteTestWithSpy {
    private static final Scenario DUMMY_SCENARIO = new Scenario();
    private static final Author DUMMY_AUTHOR = new Author();

    @Spy private InMemoryScenarioRepository scenarioRepository;
    @Mock private ExternalScenarioValidator scenarioValidator;
    @InjectMocks private ScenariosSuite scenariosSuite;

    @Test
    public void shouldStoreValidScenario() {
        givenValidScenario();

        scenariosSuite.accept(DUMMY_SCENARIO, DUMMY_AUTHOR);

        then(scenarioRepository).should().store(DUMMY_SCENARIO, DUMMY_AUTHOR);
        assertThat(scenarioRepository.howManyScenariosFor(DUMMY_AUTHOR)).isEqualTo(1);
    }

    private void givenValidScenario() {
        given(scenarioValidator.isValid(any())).willReturn(true);
    }

    @Test
    public void shouldNotStoreInValidScenario() {
        givenInvalidScenario();

        scenariosSuite.accept(DUMMY_SCENARIO, DUMMY_AUTHOR);

        then(scenarioRepository).should(never()).store(DUMMY_SCENARIO, DUMMY_AUTHOR);
        assertThat(scenarioRepository.howManyScenariosFor(DUMMY_AUTHOR)).isEqualTo(0);
    }

    private void givenInvalidScenario() {
        given(scenarioValidator.isValid(any())).willReturn(false);
    }
}

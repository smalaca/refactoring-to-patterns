package com.smalaca.testdoublepatterns.scenario;

import com.smalaca.testdoublepatterns.scenario.domain.Author;
import com.smalaca.testdoublepatterns.scenario.domain.Scenario;
import com.smalaca.testdoublepatterns.scenario.externalservice.ExternalScenarioValidator;
import com.smalaca.testdoublepatterns.scenario.repository.ScenarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class ScenariosSuiteTestWithDummyObject {
    private static final Scenario DUMMY_SCENARIO = new Scenario();
    private static final Author DUMMY_AUTHOR = new Author();

    @Mock private ScenarioRepository scenarioRepository;
    @Mock private ExternalScenarioValidator scenarioValidator;
    @InjectMocks private ScenariosSuite scenariosSuite;

    @Test
    public void shouldStoreValidScenario() {
        givenValidScenario();

        scenariosSuite.accept(DUMMY_SCENARIO, DUMMY_AUTHOR);

        thenScenarioWasAddedToRepository();
    }

    private void givenValidScenario() {
        given(scenarioValidator.isValid(any())).willReturn(true);
    }

    private void thenScenarioWasAddedToRepository() {
        then(scenarioRepository).should().store(DUMMY_SCENARIO, DUMMY_AUTHOR);
    }

    @Test
    public void shouldNotStoreInValidScenario() {
        givenInvalidScenario();

        scenariosSuite.accept(DUMMY_SCENARIO, DUMMY_AUTHOR);

        thenScenarioWasNotAddedToRepository();
    }

    private void givenInvalidScenario() {
        given(scenarioValidator.isValid(any())).willReturn(false);
    }

    private void thenScenarioWasNotAddedToRepository() {
        then(scenarioRepository).should(never()).store(any(), any());
    }
}

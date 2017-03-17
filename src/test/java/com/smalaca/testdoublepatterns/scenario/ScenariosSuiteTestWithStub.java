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
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class ScenariosSuiteTestWithStub {
    @Mock private ScenarioRepository scenarioRepository;
    @Mock private ExternalScenarioValidator scenarioValidator;
    @InjectMocks private ScenariosSuite scenariosSuite;

    @Test
    public void shouldStoreValidScenario() {
        givenAlwaysTrueStubbedValidator();

        scenariosSuite.accept(aDummyScenario(), aDummyAuthor());
        scenariosSuite.accept(aDummyScenario(), aDummyAuthor());
        scenariosSuite.accept(aDummyScenario(), aDummyAuthor());

        thenAllScenariosWasAddedToRepository();
    }

    private void givenAlwaysTrueStubbedValidator() {
        given(scenarioValidator.isValid(any())).willReturn(true);
    }

    private void thenAllScenariosWasAddedToRepository() {
        then(scenarioRepository).should(times(3)).store(isA(Scenario.class), isA(Author.class));
    }

    @Test
    public void shouldNotStoreInValidScenario() {
        givenAlwaysFalseStubbedValidator();

        scenariosSuite.accept(aDummyScenario(), aDummyAuthor());
        scenariosSuite.accept(aDummyScenario(), aDummyAuthor());
        scenariosSuite.accept(aDummyScenario(), aDummyAuthor());

        thenScenariosWasNotAddedToRepository();
    }

    private void givenAlwaysFalseStubbedValidator() {
        given(scenarioValidator.isValid(any())).willReturn(false);
    }

    private void thenScenariosWasNotAddedToRepository() {
        then(scenarioRepository).should(never()).store(any(), any());
    }

    private Scenario aDummyScenario() {
        return new Scenario();
    }

    private Author aDummyAuthor() {
        return new Author();
    }
}

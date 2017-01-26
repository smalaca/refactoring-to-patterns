package com.smalaca.processors.complex;

import com.smalaca.domain.InputParameter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class VoidIfElseComplexProcessorTest {
    private static final InputParameter DUMMY_INPUT_PARAMETER = null;

    @Mock private RequirementsVerification1 predicate1;
    @Mock private RequirementsVerification2 predicate2;
    @Mock private Processor1 processorl;
    @Mock private Processor2 processor2;
    @Mock private Processor3 processor3;
    @Mock private Processor4 processor4;

    @InjectMocks private VoidIfElseComplexProcessor complexProcessor;

    @Test
    public void shouldExecuteUnconditionalOperations() {
        complexProcessor.process(DUMMY_INPUT_PARAMETER);

        then(processor3).should().theresJobToDoFor(DUMMY_INPUT_PARAMETER);
        then(processor2).should().thatIsNotAllFor(DUMMY_INPUT_PARAMETER);
        then(processor2).should().weAreAlmostThereWith(DUMMY_INPUT_PARAMETER);
        then(processor4).should().jobIsDoneFor(DUMMY_INPUT_PARAMETER);
    }

    @Test
    public void shouldExecuteOperationWhenSomeRequirementsAreMet() {
        given(predicate1.areSomeRequirementsMet(DUMMY_INPUT_PARAMETER)).willReturn(true);

        complexProcessor.process(DUMMY_INPUT_PARAMETER);

        then(processorl).should().doSomething(DUMMY_INPUT_PARAMETER);
        then(processorl).should().doSomethingElse(DUMMY_INPUT_PARAMETER);
        then(processor2).should().doSomethingMore(DUMMY_INPUT_PARAMETER);
    }

    @Test
    public void shouldNotExecuteOperationWhenSomeRequirementsAreNotMet() {
        given(predicate1.areSomeRequirementsMet(DUMMY_INPUT_PARAMETER)).willReturn(false);

        complexProcessor.process(DUMMY_INPUT_PARAMETER);

        then(processorl).should(never()).doSomething(DUMMY_INPUT_PARAMETER);
        then(processorl).should(never()).doSomethingElse(DUMMY_INPUT_PARAMETER);
        then(processor2).should(never()).doSomethingMore(DUMMY_INPUT_PARAMETER);
    }

    @Test
    public void shouldExecuteOperationWhenOtherRequirementsAreMet() {
        given(predicate2.areOtherRequirementsMet(DUMMY_INPUT_PARAMETER)).willReturn(true);

        complexProcessor.process(DUMMY_INPUT_PARAMETER);

        then(processorl).should().doSomethingElse(DUMMY_INPUT_PARAMETER);
        then(processor2).should().yetAnotherThingToDoFor(DUMMY_INPUT_PARAMETER);
    }

    @Test
    public void shouldNotExecuteOperationWhenOtherRequirementsAreNotMet() {
        given(predicate2.areOtherRequirementsMet(DUMMY_INPUT_PARAMETER)).willReturn(false);

        complexProcessor.process(DUMMY_INPUT_PARAMETER);

        then(processorl).should(never()).doSomethingElse(DUMMY_INPUT_PARAMETER);
        then(processor2).should(never()).yetAnotherThingToDoFor(DUMMY_INPUT_PARAMETER);
    }
}

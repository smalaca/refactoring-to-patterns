package com.smalaca.designpatterns.chainofresponsibility.processors.complex;

import com.smalaca.domain.InputParameter;

class VoidIfElseComplexProcessor {
    private RequirementsVerification1 predicate1;
    private RequirementsVerification2 predicate2;
    private Processor1 processorl;
    private Processor2 processor2;
    private Processor3 processor3;
    private Processor4 processor4;

    VoidIfElseComplexProcessor(
            RequirementsVerification1 predicate1, RequirementsVerification2 predicate2,
            Processor1 processorl, Processor2 processor2, Processor3 processor3, Processor4 processor4) {
        this.predicate1 = predicate1;
        this.predicate2 = predicate2;
        this.processorl = processorl;
        this.processor2 = processor2;
        this.processor3 = processor3;
        this.processor4 = processor4;
    }

    void process(InputParameter inputParameter) {
        if (predicate1.areSomeRequirementsMet(inputParameter)){
            processorl.doSomething(inputParameter);
            processorl.doSomethingElse(inputParameter);
            processor2.doSomethingMore(inputParameter);
        }

        processor3.theresJobToDoFor(inputParameter);
        processor2.thatIsNotAllFor(inputParameter);

        if (predicate2.areOtherRequirementsMet(inputParameter)){
            processorl.doSomethingElse(inputParameter);
            processor2.yetAnotherThingToDoFor(inputParameter);
        }

        processor2.weAreAlmostThereWith(inputParameter);
        processor4.jobIsDoneFor(inputParameter);
    }
}

package com.smalaca.designpatterns.chainofresponsibility.processors.complex;

import com.smalaca.domain.InputParameter;

interface Processor2 {
    void doSomethingMore(InputParameter inputParameter);

    void thatIsNotAllFor(InputParameter inputParameter);

    void yetAnotherThingToDoFor(InputParameter inputParameter);

    void weAreAlmostThereWith(InputParameter inputParameter);
}

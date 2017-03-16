package com.smalaca.designpatterns.chainofresponsibility.processors.complex;

import com.smalaca.domain.InputParameter;

interface Processor1 {
    void doSomething(InputParameter inputParameter);

    void doSomethingElse(InputParameter inputParameter);
}

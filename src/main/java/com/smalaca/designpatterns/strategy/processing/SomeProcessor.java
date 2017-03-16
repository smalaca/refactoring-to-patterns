package com.smalaca.designpatterns.strategy.processing;

import com.smalaca.domain.InputParameter;

public class SomeProcessor {
    private final ProcessingType processingType;
    private final ProcessImplType1 processImplType1;
    private final ProcessImplType2 processImplType2;
    private final ProcessImplType3 processImplType3;

    public SomeProcessor(
            ProcessingType processingType, ProcessImplType1 processImplType1, ProcessImplType2 processImplType2, ProcessImplType3 processImplType3) {
        this.processingType = processingType;
        this.processImplType1 = processImplType1;
        this.processImplType2 = processImplType2;
        this.processImplType3 = processImplType3;
    }

    public void process(InputParameter inputParameter) {
        switch (processingType) {
            case TYPE_1:
                doSomethingInOneWay(inputParameter);
                break;

            case TYPE_2:
                doTheSameInAnotherWay(inputParameter);
                break;

            case TYPE_3:
                doTheSameInDifferentWay(inputParameter);
                break;
        }
    }

    private void doSomethingInOneWay(InputParameter inputParameter) {
        processImplType1.process(inputParameter);
    }

    private void doTheSameInAnotherWay(InputParameter inputParameter) {
        processImplType2.process(inputParameter);
    }

    private void doTheSameInDifferentWay(InputParameter inputParameter) {
        processImplType3.process(inputParameter);
    }
}

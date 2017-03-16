package com.smalaca.designpatterns.visitor.processing;

import com.smalaca.designpatterns.visitor.domain.InputParameter;
import com.smalaca.designpatterns.visitor.domain.Parameter1;
import com.smalaca.designpatterns.visitor.domain.Parameter2;
import com.smalaca.designpatterns.visitor.domain.Parameter3;

public class SomeProcessor {
    private final Processor1 processor1;
    private final Processor2 processor2;
    private final Processor3 processor3;

    public SomeProcessor(Processor1 processor1, Processor2 processor2, Processor3 processor3) {
        this.processor1 = processor1;
        this.processor2 = processor2;
        this.processor3 = processor3;
    }

    public void process(InputParameter inputParameter) {
        if (inputParameter instanceof Parameter1) {
            doSomething((Parameter1) inputParameter);
        } else if (inputParameter instanceof Parameter2) {
            doSomething((Parameter2) inputParameter);
        } else if (inputParameter instanceof Parameter3) {
            doSomething((Parameter3) inputParameter);
        }
    }

    private void doSomething(Parameter1 inputParameter) {
        processor1.process(inputParameter);
    }

    private void doSomething(Parameter2 inputParameter) {
        processor2.process(inputParameter);
    }

    private void doSomething(Parameter3 inputParameter) {
        processor3.process(inputParameter);
    }
}

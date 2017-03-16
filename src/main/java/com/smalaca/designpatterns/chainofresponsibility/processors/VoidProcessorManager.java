package com.smalaca.designpatterns.chainofresponsibility.processors;

import com.smalaca.domain.InputParameter;

import java.util.List;

class VoidProcessorManager {
    private final List<Processor> processors;

    VoidProcessorManager(List<Processor> processors) {
        this.processors = processors;
    }

    void process(InputParameter inputParameter) {
        for (Processor processor : processors) {
            if (processor.isApplicableFor(inputParameter)) {
                processor.process(inputParameter);
            }
        }
    }
}

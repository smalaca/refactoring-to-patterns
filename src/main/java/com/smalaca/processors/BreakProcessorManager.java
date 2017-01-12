package com.smalaca.processors;

import com.smalaca.domain.InputParameter;

import java.util.List;

class BreakProcessorManager {
    private final List<Processor> processors;

    BreakProcessorManager(List<Processor> processors) {
        this.processors = processors;
    }

    void process(InputParameter inputParameter) {
        for (Processor processor : processors) {
            if (processor.isApplicableFor(inputParameter)) {
                processor.process(inputParameter);
                break;
            }
        }
    }
}

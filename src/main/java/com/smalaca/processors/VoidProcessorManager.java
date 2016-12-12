package com.smalaca.processors;

import com.smalaca.domain.InputParameter;

import java.util.List;

public class VoidProcessorManager {
    private final List<Processor> processors;

    public VoidProcessorManager(List<Processor> processors) {
        this.processors = processors;
    }

    public void process(InputParameter inputParameter) {
        for (Processor processor : processors) {
            if (processor.isApplicableFor(inputParameter)) {
                processor.process(inputParameter);
            }
        }
    }
}

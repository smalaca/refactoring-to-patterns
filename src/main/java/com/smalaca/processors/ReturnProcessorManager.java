package com.smalaca.processors;

import com.smalaca.domain.InputParameter;
import com.smalaca.domain.OutputParameter;

import java.util.List;

class ReturnProcessorManager {
    private final List<Processor> processors;

    ReturnProcessorManager(List<Processor> processors) {
        this.processors = processors;
    }

    OutputParameter process(InputParameter inputParameter) {
        for (Processor processor : processors) {
            if (processor.isApplicableFor(inputParameter)) {
                return processor.process(inputParameter);
            }
        }

        return null;
    }
}

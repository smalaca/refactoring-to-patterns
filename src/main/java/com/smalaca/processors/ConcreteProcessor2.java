package com.smalaca.processors;

import com.smalaca.domain.InputParameter;
import com.smalaca.domain.OutputParameter;

public class ConcreteProcessor2 implements Processor {
    @Override
    public boolean isApplicableFor(InputParameter inputParameter) {
        return false;
    }

    @Override
    public OutputParameter process(InputParameter inputParameter) {
        return null;
    }
}

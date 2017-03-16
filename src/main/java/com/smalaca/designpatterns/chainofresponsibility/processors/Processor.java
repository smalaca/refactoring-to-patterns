package com.smalaca.designpatterns.chainofresponsibility.processors;

import com.smalaca.domain.InputParameter;
import com.smalaca.domain.OutputParameter;

public interface Processor {
    boolean isApplicableFor(InputParameter inputParameter);

    OutputParameter process(InputParameter inputParameter);
}

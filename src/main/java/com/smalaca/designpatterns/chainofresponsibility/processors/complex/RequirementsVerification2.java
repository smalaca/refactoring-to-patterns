package com.smalaca.designpatterns.chainofresponsibility.processors.complex;

import com.smalaca.domain.InputParameter;

interface RequirementsVerification2 {
    boolean areOtherRequirementsMet(InputParameter inputParameter);
}

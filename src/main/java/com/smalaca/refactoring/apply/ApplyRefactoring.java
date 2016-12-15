package com.smalaca.refactoring.apply;

import com.smalaca.refactoring.domain.ClassCode;
import com.smalaca.refactoring.domain.Condition;
import com.smalaca.refactoring.domain.Refactoring;

public class ApplyRefactoring {
    public void apply(ClassCode code, Refactoring refactoring) {
        Condition condition = code.getMethodByName(refactoring.getScope()).getCondition();
        RefactoringApplier.applyRefactoringFor(condition, refactoring);
    }
}

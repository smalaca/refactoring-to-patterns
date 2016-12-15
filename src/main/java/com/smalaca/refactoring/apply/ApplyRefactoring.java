package com.smalaca.refactoring.apply;

import com.smalaca.refactoring.domain.ClassCode;
import com.smalaca.refactoring.domain.Condition;
import com.smalaca.refactoring.domain.Refactoring;
import com.smalaca.refactoring.domain.RefactoringScope;

public class ApplyRefactoring {
    public void apply(ClassCode code, Refactoring refactoring) {
        RefactoringScope refactoringScope = refactoring.getScope();
        Condition condition = code.getMethodByName(refactoringScope).getCondition();
        RefactoringApplier.applyRefactoringFor(condition, refactoring);
    }
}

package com.smalaca.refactoring.presentation.apply;

import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.domain.Condition;
import com.smalaca.refactoring.presentation.domain.Refactoring;
import com.smalaca.refactoring.presentation.domain.RefactoringScope;

public class ApplyRefactoring {
    public void apply(ClassCode code, Refactoring refactoring) {
        RefactoringScope refactoringScope = refactoring.getScope();
        Condition condition = code.getMethodByName(refactoringScope).getCondition();
        RefactoringApplier.applyRefactoringFor(condition, refactoring);
    }
}

package com.smalaca.refactoring.presentation.domain;

public class ClassCode {
    private boolean complex;
    private boolean unreadable;
    private boolean improved;
    private long complexity;

    public ClassMethod getMethodByName(RefactoringScope scope) {
        return null;
    }

    public boolean isComplex() {
        return complex;
    }

    public boolean isUnreadable() {
        return unreadable;
    }

    public void refactorBy(Developer developer) {

    }

    public void apply(Refactoring refactoring) {

    }

    public long getComplexity() {
        return complexity;
    }

    public boolean isComplexOrUnreadable() {
        return isComplex() || isUnreadable();
    }
}

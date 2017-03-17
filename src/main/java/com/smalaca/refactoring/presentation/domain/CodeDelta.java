package com.smalaca.refactoring.presentation.domain;

public class CodeDelta {
    private ClassCode classCode;
    private Refactoring refactoring;
    private Author author;

    public ClassCode getClassCode() {
        return classCode;
    }

    public Refactoring getRefactoring() {
        return refactoring;
    }

    public void markAsRejected() {

    }

    public Author getAuthor() {
        return author;
    }
}

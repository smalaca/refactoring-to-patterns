package com.smalaca.refactoring.repository;

import com.smalaca.refactoring.domain.Author;
import com.smalaca.refactoring.domain.ClassCode;
import com.smalaca.refactoring.domain.Refactoring;
import com.smalaca.refactoring.domain.RefactoringJustification;
import com.smalaca.refactoring.domain.RefactoringScope;
import com.smalaca.refactoring.domain.RefactoringType;

import java.util.Date;

public class History {
    public void store(Author author, RefactoringType type, RefactoringScope scope, RefactoringJustification justification, Date date) {

    }

    public void store(Author author, ClassCode classCode, Refactoring refactoring) {

    }
}

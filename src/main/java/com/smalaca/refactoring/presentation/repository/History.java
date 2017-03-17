package com.smalaca.refactoring.presentation.repository;

import com.smalaca.refactoring.presentation.domain.Author;
import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.domain.Refactoring;
import com.smalaca.refactoring.presentation.domain.RefactoringJustification;
import com.smalaca.refactoring.presentation.domain.RefactoringScope;
import com.smalaca.refactoring.presentation.domain.RefactoringType;

import java.util.Date;

public class History {
    public void store(Author author, RefactoringType type, RefactoringScope scope, RefactoringJustification justification, Date date) {

    }

    public void store(Author author, ClassCode classCode, Refactoring refactoring) {

    }
}

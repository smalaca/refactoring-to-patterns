package com.smalaca.refactoring.presentation.repository;

import com.smalaca.refactoring.presentation.domain.ClassCode;

public interface TestsRepository {
    boolean testsExistFor(ClassCode code);
}

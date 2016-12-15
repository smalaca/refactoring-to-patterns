package com.smalaca.refactoring.repository;

import com.smalaca.refactoring.domain.ClassCode;

public interface TestsRepository {
    boolean testsExistFor(ClassCode code);
}

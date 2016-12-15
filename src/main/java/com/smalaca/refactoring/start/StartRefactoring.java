package com.smalaca.refactoring.start;

import com.smalaca.refactoring.domain.ClassCode;
import com.smalaca.refactoring.domain.Developer;
import com.smalaca.refactoring.repository.TestsRepository;

class StartRefactoring {
    private TestsRepository testsRepository;

    public void start(ClassCode code, Developer developer) {
        if (testsRepository.testsExistFor(code) && developer.canModify(code) &&
            (code.isComplex() || code.isUnreadable())) {
            startRefactoringOf(code, developer);
        }
    }

    private void startRefactoringOf(ClassCode code, Developer developer) {
        code.refactorBy(developer);
    }
}

package com.smalaca.refactoring.presentation.start;

import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.domain.Developer;
import com.smalaca.refactoring.presentation.repository.TestsRepository;

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

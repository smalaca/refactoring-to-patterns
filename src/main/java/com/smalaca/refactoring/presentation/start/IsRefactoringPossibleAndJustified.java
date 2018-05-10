package com.smalaca.refactoring.presentation.start;

import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.domain.Developer;
import com.smalaca.refactoring.presentation.repository.TestsRepository;

public class IsRefactoringPossibleAndJustified {
    private final TestsRepository testsRepository;
    private final ClassCode code;
    private final Developer developer;

    IsRefactoringPossibleAndJustified(
            TestsRepository testsRepository, ClassCode code, Developer developer) {
        this.testsRepository = testsRepository;
        this.code = code;
        this.developer = developer;
    }

    public boolean check() {
        return testsRepository.testsExistFor(code) && developer.canModify(code) && code.isComplexOrUnreadable();
    }
}

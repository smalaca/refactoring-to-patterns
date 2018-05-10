package com.smalaca.refactoring.presentation.start;

import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.domain.Developer;
import com.smalaca.refactoring.presentation.repository.TestsRepository;

public class IsRefactoringPossibleAndJustifiedFactory {
    private final TestsRepository testsRepository;

    public IsRefactoringPossibleAndJustifiedFactory(TestsRepository testsRepository) {
        this.testsRepository = testsRepository;
    }

    public IsRefactoringPossibleAndJustified createFor(ClassCode code, Developer developer) {
        return new IsRefactoringPossibleAndJustified(testsRepository, code, developer);
    }
}

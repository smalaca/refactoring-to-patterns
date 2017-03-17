package com.smalaca.refactoring.presentation.codecoverage;

import com.smalaca.refactoring.presentation.domain.CodeDelta;

public interface CodeCoverageService {
    int check(CodeDelta change);
}

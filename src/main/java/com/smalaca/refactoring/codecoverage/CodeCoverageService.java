package com.smalaca.refactoring.codecoverage;

import com.smalaca.refactoring.domain.CodeDelta;

public interface CodeCoverageService {
    int check(CodeDelta change);
}

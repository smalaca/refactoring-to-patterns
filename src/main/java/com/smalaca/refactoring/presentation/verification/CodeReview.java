package com.smalaca.refactoring.presentation.verification;

import com.smalaca.refactoring.presentation.codecoverage.CodeCoverageService;
import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.domain.CodeBase;
import com.smalaca.refactoring.presentation.domain.CodeDelta;
import com.smalaca.refactoring.presentation.notification.NotificationService;
import com.smalaca.refactoring.presentation.repository.History;

class CodeReview {
    private CodeCoverageService codeCoverage;
    private CodeBase codeBase;
    private History history;
    private NotificationService notificationService;

    void doReviewOf(ClassCode currentCode, CodeDelta change) {
        if (codeCoverage.check(change) > 97 && change.getClassCode().lessComplexThan(currentCode)) {
            currentCode.apply(change.getRefactoring());
            codeBase.merge(currentCode);
            history.store(change.getAuthor(), change.getClassCode(), change.getRefactoring());
        } else {
            change.markAsRejected();
            notificationService.changeRejected(change.getAuthor());
        }
    }
}

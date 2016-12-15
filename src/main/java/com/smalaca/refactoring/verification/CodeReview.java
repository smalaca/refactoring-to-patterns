package com.smalaca.refactoring.verification;

import com.smalaca.refactoring.codecoverage.CodeCoverageService;
import com.smalaca.refactoring.domain.ClassCode;
import com.smalaca.refactoring.domain.CodeBase;
import com.smalaca.refactoring.domain.CodeDelta;
import com.smalaca.refactoring.notification.NotificationService;
import com.smalaca.refactoring.repository.History;

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

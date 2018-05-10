package com.smalaca.refactoring.presentation.verification;

import com.smalaca.refactoring.presentation.codecoverage.CodeCoverageService;
import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.domain.CodeBase;
import com.smalaca.refactoring.presentation.domain.CodeDelta;
import com.smalaca.refactoring.presentation.notification.NotificationService;
import com.smalaca.refactoring.presentation.repository.ChangeRepository;

class CodeReview {
    private CodeCoverageService codeCoverage;
    private CodeBase codeBase;
    private ChangeRepository changeRepository;
    private NotificationService notificationService;

    void doReviewOf(ClassCode currentCode, CodeDelta change) {
        if (codeCoverage.check(change) > 97 && change.getClassCode().getComplexity() < currentCode.getComplexity()) {
            currentCode.apply(change.getRefactoring());
            codeBase.merge(currentCode);
            changeRepository.store(change);
        } else {
            change.markAsRejected();
            notificationService.changeRejected(change.getAuthor());
        }
    }
}

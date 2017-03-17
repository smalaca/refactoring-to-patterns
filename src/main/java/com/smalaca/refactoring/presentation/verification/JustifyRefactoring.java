package com.smalaca.refactoring.presentation.verification;

import com.smalaca.refactoring.presentation.domain.ClassCode;
import com.smalaca.refactoring.presentation.notification.NotificationService;

public class JustifyRefactoring {
    private NotificationService notification;

    public void check (ClassCode code) {
        if (code.isComplex() || code.isUnreadable()) {
            sendToRefactoring(code);
        }
    }

    private void sendToRefactoring(ClassCode code) {
        notification.justifyRefactoringOf(code);
    }
}

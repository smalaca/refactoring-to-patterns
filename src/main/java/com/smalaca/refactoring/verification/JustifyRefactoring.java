package com.smalaca.refactoring.verification;

import com.smalaca.refactoring.domain.ClassCode;
import com.smalaca.refactoring.notification.NotificationService;

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

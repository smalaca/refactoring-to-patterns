package com.smalaca.refactoring.notification;

import com.smalaca.refactoring.domain.ClassCode;

public interface NotificationService {
    void justifyRefactoringOf(ClassCode code);
}

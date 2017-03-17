package com.smalaca.refactoring.presentation.notification;

import com.smalaca.refactoring.presentation.domain.Author;
import com.smalaca.refactoring.presentation.domain.ClassCode;

public interface NotificationService {
    void justifyRefactoringOf(ClassCode code);

    void changeRejected(Author author);
}

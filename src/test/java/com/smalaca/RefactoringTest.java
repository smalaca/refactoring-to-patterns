package com.smalaca;

import org.junit.Test;

import static com.smalaca.RefactoringTest.Refactoring.aRefactoring;
import static org.assertj.core.api.Assertions.assertThat;

public class RefactoringTest {
    @Test
    public void shouldTellIfRefactoringIsFun() {
        assertThat(aRefactoring().isFun()).isTrue();
    }

    static class Refactoring {
        private static final boolean ALWAYS_FUN = true;

        static Refactoring aRefactoring() {
            return new Refactoring();
        }

        boolean isFun() {
            return ALWAYS_FUN;
        }
    }
}

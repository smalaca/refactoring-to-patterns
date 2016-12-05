package com.smalaca.refactoring;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaygroundTest {
    @Test
    public void shouldReturnAppropriatePlaygroundName() {
        assertThat(new Playground().playgroundFor()).isEqualTo("Refactoring to Patterns!");
    }
}
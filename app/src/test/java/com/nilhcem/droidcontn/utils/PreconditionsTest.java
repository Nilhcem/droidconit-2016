package com.nilhcem.droidcontn.utils;

import org.junit.Test;

public class PreconditionsTest {

    @Test
    public void should_do_nothing_when_argument_is_valid() {
        // Given
        boolean argument = 1 == 1;

        // When
        Preconditions.checkArgument(argument);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_when_argument_is_invalid() {
        // Given
        boolean argument = 1 != 1;

        // When
        Preconditions.checkArgument(argument);
    }
}
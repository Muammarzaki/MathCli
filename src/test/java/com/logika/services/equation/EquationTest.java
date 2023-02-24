package com.logika.services.equation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.regex.PatternSyntaxException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EquationTest {
    @Test
    void testGeneralisEquation() {
        assertThrowsExactly(PatternSyntaxException.class, () -> {
            new Equation().generalisEquation("-2x^2+4xb^93+-4xb^4*8+83+4444");
        });
        assertDoesNotThrow(() -> {
            new Equation().generalisEquation("-2x^2+4xb^93+4xb^4+8*83+4444");
        });

    }

    @Disabled
    @Test
    void testGetRoot() {

    }

    @Disabled
    @Test
    void testGetSolver() {

    }
}

package com.logika.services.logicops;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class BasicOperationSingeltonTest {
    BasicOperation intence1;
    BasicOperation intence;

    @Test
    void testGetIntence() {
        intence1 = BasicOperationSingelton.getIntence("p", "q");
        intence = BasicOperationSingelton.getIntence("p", "q");
        assertSame(intence1, intence);
    }

    @Test
    void testsecondgetintence() {
        BasicOperation intence = BasicOperationSingelton.getIntence("p", "s");
        assertNotSame(intence1, intence);

    }
}

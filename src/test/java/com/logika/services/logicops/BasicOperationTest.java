package com.logika.services.logicops;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BasicOperationTest {
    BasicOperation bsc;

    @Test
    void testAndOps() {
        List<Boolean> p2 = List.of(true, true, false, false);
        List<Boolean> p1 = List.of(true, false, true, false);
        Object[] exp = List.of(true, false, false, false).toArray();

        List<Boolean> andOps = BasicOperation.andOps(p1, p2);
        assertArrayEquals(exp, andOps.toArray());
    }

    @Test
    void testOrpOps() {
        List<Boolean> p2 = List.of(true, true, false, false);
        List<Boolean> p1 = List.of(true, false, true, false);
        Object[] exp = List.of(true, true, true, false).toArray();

        List<Boolean> andOps = BasicOperation.orOps(p1, p2);
        assertArrayEquals(exp, andOps.toArray());
    }

    @Test
    void testImpOps() {
        List<Boolean> p1 = List.of(true, false, true, false);
        List<Boolean> p2 = List.of(true, true, false, false);
        Object[] exp = List.of(true, true, false, true).toArray();

        List<Boolean> andOps = BasicOperation.impOps(p1, p2);
        assertArrayEquals(exp, andOps.toArray());
    }

    @Test
    void testBimpOps() {
        List<Boolean> p2 = List.of(true, true, false, false);
        List<Boolean> p1 = List.of(true, false, true, false);
        Object[] exp = List.of(true, false, false, true).toArray();

        List<Boolean> andOps = BasicOperation.bimpOps(p1, p2);
        assertArrayEquals(exp, andOps.toArray());
    }

}

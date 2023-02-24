package com.logika.services.logicops;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicOperationTest {
    BasicOperation bsc;

    @Test
    void testName() {
        assertTimeoutPreemptively(Duration.ofMillis(50), () -> {
            bsc.getTableChart().get("p");
        });
        List<Boolean> list = bsc.getTableChart().get("p");
        assertArrayEquals(List.of(true, true, false, false).toArray(), list.toArray());
        list = bsc.getTableChart().get("q");
        assertArrayEquals(List.of(true, false, true, false).toArray(), list.toArray());
    }

    @BeforeEach
    void setUp() {
        bsc = new BasicOperation("p", "q");
    }

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

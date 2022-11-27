package com.logika.services.logicops;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicOperationTest {
    BasicOperation bsc;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    // @Test
    // public void testDanOps() {
    // BasicOperation basicOperation = new BasicOperation();
    // assertNotNull(basicOperation.andOps());
    // assertArrayEquals(List.of(true, false, false, false).toArray(),
    // basicOperation.andOps().toArray());
    // }

    // @Test
    // void testorOps() {
    // BasicOperation basicOperation = new BasicOperation();

    // assertNotNull(basicOperation.orOps());
    // assertArrayEquals(List.of(true, true, true, false).toArray(),
    // basicOperation.orOps().toArray());
    // }

    // @Test
    // void bimOpsTest() {
    // BasicOperation basicOperation = new BasicOperation();
    // assertNotNull(basicOperation.impOps());
    // assertArrayEquals(List.of(true, false, true, true).toArray(),
    // basicOperation.impOps().toArray());
    // }

    // @Test
    // void bimOps2Test() {
    // BasicOperation basicOperation = new BasicOperation();
    // assertNotNull(basicOperation.bimpOps());
    // assertArrayEquals(List.of(true, false, false, true).toArray(),
    // basicOperation.bimpOps().toArray());
    // }
    @Test
    void checkSize3() {
        bsc = new BasicOperation("p", "q", "r");
        assertEquals(3, bsc.getTable().size());
        System.out.println(bsc.getTable().get(2));
        assertEquals(8, bsc.getTable().get(0).size());
    }

    @Test
    void checkSize2() {
        bsc = new BasicOperation("p", "q");
        assertEquals(2, bsc.getTable().size());
        System.out.println(bsc.getTable().get(0));
        assertEquals(4, bsc.getTable().get(0).size());
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

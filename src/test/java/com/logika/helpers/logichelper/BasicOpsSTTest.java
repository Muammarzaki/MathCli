package com.logika.helpers.logichelper;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import com.logika.services.logicops.BasicOperation;

public class BasicOpsSTTest {

    @Test
    void testGetInstens() {
        BasicOperation instens = BasicOpsST.getInstens();
        BasicOperation instens2 = BasicOpsST.getInstens();
        assertSame(instens2, instens);
    }
}

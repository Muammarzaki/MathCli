package com.logika.services.logicops;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class NegasiTest {

        @Test
        void testNegasi() {
                BasicOperation basicOperation = new BasicOperation();

                assertNotNull(Negasi.negasi(List.of(true, false)));
                assertArrayEquals(List.of(false, true).toArray(), Negasi.negasi(List.of(true, false)).toArray());
                assertArrayEquals(List.of(false, true, false, true).toArray(),
                                Negasi.negasi(List.of(true, false, true, false)).toArray());

                assertArrayEquals(List.of(false, true, true, true).toArray(),
                                Negasi.negasi(basicOperation.andOps()).toArray());
                assertArrayEquals(List.of(false, false, false, true).toArray(),
                                Negasi.negasi(basicOperation.orOps()).toArray());
                assertArrayEquals(List.of(false, true, false, false).toArray(),
                                Negasi.negasi(basicOperation.impOps()).toArray());
                assertArrayEquals(List.of(false, true, true, false).toArray(),
                                Negasi.negasi(basicOperation.bimpOps()).toArray());

        }

        @Test
        void singelNegasitest() {
                assertTrue(Negasi.negasi(false));
        }

        @Test
        void boolArrayTest() {
                Boolean[] condition = { false, true, true, false };
                assertNotNull(Negasi.negasi(condition));
                assertArrayEquals(List.of(true, false, false, true).toArray(), Negasi.negasi(condition).toArray());
        }

}

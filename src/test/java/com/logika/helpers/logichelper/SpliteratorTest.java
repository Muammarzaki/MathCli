package com.logika.helpers.logichelper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SpliteratorTest {
        /**
         * 
         */
        @Test
        void testSplits() {
                assertNotNull(Spliterator.Spliters("~q"));
                assertArrayEquals(List.of(false, false, true, true).toArray(), Spliterator.Spliters("~p").toArray());

                assertArrayEquals(List.of(false, true, true, true).toArray(), Spliterator.Spliters("~(p&q)").toArray());
                assertArrayEquals(List.of(true, true, false, true).toArray(),
                                Spliterator.Spliters("~(~p&q)").toArray());
                assertArrayEquals(List.of(true, false, true, true).toArray(),
                                Spliterator.Spliters("~(p&~q)").toArray());
                assertArrayEquals(List.of(true, true, true, false).toArray(),
                                Spliterator.Spliters("~(~p&~q)").toArray());

                assertArrayEquals(List.of(false, false, false, true).toArray(),
                                Spliterator.Spliters("~(p|q)").toArray());
                assertArrayEquals(List.of(false, true, false, false).toArray(),
                                Spliterator.Spliters("~(~p|q)").toArray());
                assertArrayEquals(List.of(false, false, true, false).toArray(),
                                Spliterator.Spliters("~(p|~q)").toArray());
                assertArrayEquals(List.of(true, false, false, false).toArray(),
                                Spliterator.Spliters("~(~p|~q)").toArray());

                assertArrayEquals(List.of(false, true, false, false).toArray(),
                                Spliterator.Spliters("~(p-q)").toArray());
                assertArrayEquals(List.of(false, false, false, true).toArray(),
                                Spliterator.Spliters("~(~p-q)").toArray());
                assertArrayEquals(List.of(true, false, false, false).toArray(),
                                Spliterator.Spliters("~(p-~q)").toArray());
                assertArrayEquals(List.of(false, false, true, false).toArray(),
                                Spliterator.Spliters("~(~p-~q)").toArray());

                assertArrayEquals(List.of(false, true, true, false).toArray(),
                                Spliterator.Spliters("~(p#q)").toArray());
                assertArrayEquals(List.of(true, false, false, true).toArray(),
                                Spliterator.Spliters("~(~p#q)").toArray());
                assertArrayEquals(List.of(true, false, false, true).toArray(),
                                Spliterator.Spliters("~(p#~q)").toArray());
                assertArrayEquals(List.of(false, true, true, false).toArray(),
                                Spliterator.Spliters("~(~p#~q)").toArray());

                assertArrayEquals(List.of(true, false, false, false).toArray(), Spliterator.Spliters("p&q").toArray());
                assertArrayEquals(List.of(false, false, true, false).toArray(), Spliterator.Spliters("~p&q").toArray());
                assertArrayEquals(List.of(false, true, false, false).toArray(), Spliterator.Spliters("p&~q").toArray());
                assertArrayEquals(List.of(false, false, false, true).toArray(),
                                Spliterator.Spliters("~p&~q").toArray());

                assertArrayEquals(List.of(true, true, true, false).toArray(), Spliterator.Spliters("p|q").toArray());
                assertArrayEquals(List.of(true, false, true, true).toArray(), Spliterator.Spliters("~p|q").toArray());
                assertArrayEquals(List.of(true, true, false, true).toArray(), Spliterator.Spliters("p|~q").toArray());
                assertArrayEquals(List.of(false, true, true, true).toArray(), Spliterator.Spliters("~p|~q").toArray());

                assertArrayEquals(List.of(true, false, true, true).toArray(), Spliterator.Spliters("p-q").toArray());
                assertArrayEquals(List.of(true, true, true, false).toArray(), Spliterator.Spliters("~p-q").toArray());
                assertArrayEquals(List.of(false, true, true, true).toArray(), Spliterator.Spliters("p-~q").toArray());
                assertArrayEquals(List.of(true, true, false, true).toArray(), Spliterator.Spliters("~p-~q").toArray());

                assertArrayEquals(List.of(true, false, false, true).toArray(), Spliterator.Spliters("p#q").toArray());
                assertArrayEquals(List.of(false, true, true, false).toArray(), Spliterator.Spliters("~p#q").toArray());
                assertArrayEquals(List.of(false, true, true, false).toArray(), Spliterator.Spliters("p#~q").toArray());
                assertArrayEquals(List.of(true, false, false, true).toArray(), Spliterator.Spliters("~p#~q").toArray());
        }

        @Test
        void testIfnegasi() {
                Spliterator spliterator = new Spliterator();
                Spliterator spliterator2 = new Spliterator();
                Spliterator spliterator3 = new Spliterator();
                assertFalse(spliterator.ifnegasi("t"));
                assertTrue(spliterator.ifnegasi("~p"));
                assertArrayEquals(List.of(false, false, true, true).toArray(),
                                spliterator.basicOperation.getP().toArray());
                assertTrue(spliterator.ifnegasi("~q"));
                assertArrayEquals(List.of(false, true, false, true).toArray(),
                                spliterator.basicOperation.getQ().toArray());
                assertTrue(spliterator2.ifnegasi("~p&~q"));
                assertArrayEquals(List.of(false, true, false, true).toArray(),
                                spliterator2.basicOperation.getPl2().toArray());
                assertArrayEquals(List.of(false, false, true, true).toArray(),
                                spliterator2.basicOperation.getPl1().toArray());
                assertTrue(spliterator3.ifnegasi("~q&~p"));
                assertArrayEquals(List.of(false, true, false, true).toArray(),
                                spliterator3.basicOperation.getPl2().toArray());
                assertArrayEquals(List.of(false, false, true, true).toArray(),
                                spliterator3.basicOperation.getPl1().toArray());
        }

        @Test
        void cleanStringTest() {
                Spliterator spliterator = new Spliterator();
                assertEquals("p&q", spliterator.cleanString("~p&~q"));
                assertEquals("p&q", spliterator.cleanString("p&~q"));
                assertEquals("p&q", spliterator.cleanString("~p&q"));
        }

        @Test
        void findMethodTest() {
                Spliterator spliterator = new Spliterator();
                assertNull(spliterator.findMethod("w&q"));
                assertNull(spliterator.findMethod("~w&q"));
                assertNotNull(spliterator.findMethod("~p&q"));
                assertNotNull(spliterator.findMethod("p&~q"));
                assertNotNull(spliterator.findMethod("~p&~q"));

                assertArrayEquals(List.of(true, false, false, false).toArray(),
                                spliterator.findMethod("p&q").toArray());
                assertArrayEquals(List.of(false, false, true, false).toArray(),
                                spliterator.findMethod("~p&q").toArray());
                assertArrayEquals(List.of(false, true, false, false).toArray(),
                                spliterator.findMethod("p&~q").toArray());
                assertArrayEquals(List.of(false, false, false, true).toArray(),
                                spliterator.findMethod("~p&~q").toArray());

                assertArrayEquals(List.of(true, true, true, false).toArray(),
                                spliterator.findMethod("p|q").toArray());
                assertArrayEquals(List.of(true, false, true, true).toArray(),
                                spliterator.findMethod("~p|q").toArray());
                assertArrayEquals(List.of(true, true, false, true).toArray(),
                                spliterator.findMethod("p|~q").toArray());
                assertArrayEquals(List.of(false, true, true, true).toArray(),
                                spliterator.findMethod("~p|~q").toArray());

                assertArrayEquals(List.of(true, false, true, true).toArray(),
                                spliterator.findMethod("p-q").toArray());
                assertArrayEquals(List.of(true, true, true, false).toArray(),
                                spliterator.findMethod("~p-q").toArray());
                assertArrayEquals(List.of(false, true, true, true).toArray(),
                                spliterator.findMethod("p-~q").toArray());
                assertArrayEquals(List.of(true, true, false, true).toArray(),
                                spliterator.findMethod("~p-~q").toArray());

                assertArrayEquals(List.of(true, false, false, true).toArray(),
                                spliterator.findMethod("p#q").toArray());
                assertArrayEquals(List.of(false, true, true, false).toArray(),
                                spliterator.findMethod("~p#q").toArray());
                assertArrayEquals(List.of(false, true, true, false).toArray(),
                                spliterator.findMethod("p#~q").toArray());
                assertArrayEquals(List.of(true, false, false, true).toArray(),
                                spliterator.findMethod("~p#~q").toArray());
        }

        @Test
        void testGetbetween() {
                Spliterator spliterator = new Spliterator();
                assertEquals("q&p", spliterator.getbetween("(q&p)"));
                assertEquals("p", spliterator.getbetween("(p)"));
                assertEquals("q", spliterator.getbetween("(q)"));
                assertEquals("jancok", spliterator.getbetween("(jancok)"));
        }

}

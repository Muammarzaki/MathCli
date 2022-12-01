package com.logika.helpers.logichelper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SpliteratorTest {
        /**
         * @throws Exception
         * 
         */
        @Test
        void testSplits() throws Exception {
                Spliterators spliterator = new Spliterators();
                assertNotNull(spliterator.spliters("~q"));
                // Spliterators spliterator2 = new Spliterators();
                // assertArrayEquals(List.of(false, true).toArray(),
                // spliterator2.spliters("~p").toArray());

                // assertArrayEquals(List.of(false, true, true, true).toArray(),
                // spliterator.spliters("~(p&q)").toArray());
                // assertArrayEquals(List.of(true, true, false, true).toArray(),
                // spliterator.spliters("~(~p&q)").toArray());
                // assertArrayEquals(List.of(true, false, true, true).toArray(),
                // spliterator.spliters("~(p&~q)").toArray());
                // assertArrayEquals(List.of(true, true, true, false).toArray(),
                // spliterator.spliters("~(~p&~q)").toArray());

                // assertArrayEquals(List.of(false, false, false, true).toArray(),
                // spliterator.spliters("~(p|q)").toArray());
                // assertArrayEquals(List.of(false, true, false, false).toArray(),
                // spliterator.spliters("~(~p|q)").toArray());
                // assertArrayEquals(List.of(false, false, true, false).toArray(),
                // spliterator.spliters("~(p|~q)").toArray());
                // assertArrayEquals(List.of(true, false, false, false).toArray(),
                // spliterator.spliters("~(~p|~q)").toArray());

                // assertArrayEquals(List.of(false, true, false, false).toArray(),
                // spliterator.spliters("~(p-q)").toArray());
                // assertArrayEquals(List.of(false, false, false, true).toArray(),
                // spliterator.spliters("~(~p-q)").toArray());
                // assertArrayEquals(List.of(true, false, false, false).toArray(),
                // spliterator.spliters("~(p-~q)").toArray());
                // assertArrayEquals(List.of(false, false, true, false).toArray(),
                // spliterator.spliters("~(~p-~q)").toArray());

                // assertArrayEquals(List.of(false, true, true, false).toArray(),
                // spliterator.spliters("~(p#q)").toArray());
                // assertArrayEquals(List.of(true, false, false, true).toArray(),
                // spliterator.spliters("~(~p#q)").toArray());
                // assertArrayEquals(List.of(true, false, false, true).toArray(),
                // spliterator.spliters("~(p#~q)").toArray());
                // assertArrayEquals(List.of(false, true, true, false).toArray(),
                // spliterator.spliters("~(~p#~q)").toArray());

                // assertArrayEquals(List.of(true, false, false, false).toArray(),
                // spliterator.spliters("p&q").toArray());
                // assertArrayEquals(List.of(false, false, true, false).toArray(),
                // spliterator.spliters("~p&q").toArray());
                // assertArrayEquals(List.of(false, true, false, false).toArray(),
                // spliterator.spliters("p&~q").toArray());
                // assertArrayEquals(List.of(false, false, false, true).toArray(),
                // spliterator.spliters("~p&~q").toArray());

                // assertArrayEquals(List.of(true, true, true, false).toArray(),
                // spliterator.spliters("p|q").toArray());
                // assertArrayEquals(List.of(true, false, true, true).toArray(),
                // spliterator.spliters("~p|q").toArray());
                // assertArrayEquals(List.of(true, true, false, true).toArray(),
                // spliterator.spliters("p|~q").toArray());
                // assertArrayEquals(List.of(false, true, true, true).toArray(),
                // spliterator.spliters("~p|~q").toArray());

                // assertArrayEquals(List.of(true, false, true, true).toArray(),
                // spliterator.spliters("p-q").toArray());
                // assertArrayEquals(List.of(true, true, true, false).toArray(),
                // spliterator.spliters("~p-q").toArray());
                // assertArrayEquals(List.of(false, true, true, true).toArray(),
                // spliterator.spliters("p-~q").toArray());
                // assertArrayEquals(List.of(true, true, false, true).toArray(),
                // spliterator.spliters("~p-~q").toArray());

                // assertArrayEquals(List.of(true, false, false, true).toArray(),
                // spliterator.spliters("p#q").toArray());
                // assertArrayEquals(List.of(false, true, true, false).toArray(),
                // spliterator.spliters("~p#q").toArray());
                // assertArrayEquals(List.of(false, true, true, false).toArray(),
                // spliterator.spliters("p#~q").toArray());
                // assertArrayEquals(List.of(true, false, false, true).toArray(),
                // spliterator.spliters("~p#~q").toArray());
        }

        @Test
        void cleanStringTest() {
                Spliterators spliterator = new Spliterators();
                assertEquals("p&q", spliterator.cleanString("~p&~q"));
                assertEquals("p&q", spliterator.cleanString("p&~q"));
                assertEquals("p&q", spliterator.cleanString("~p&q"));
        }

        // @Test
        // void findMethodTest() {
        // Spliterators spliterator = new Spliterators();
        // spliterator.basicOperation = new BasicOperation("p", "q");
        // assertEquals(Collections.emptyList(), spliterator.findMethod("w&q"));
        // assertEquals(Collections.emptyList(), spliterator.findMethod("~w&q"));
        // assertNotNull(spliterator.findMethod("~p&q"));
        // assertNotNull(spliterator.findMethod("p&~q"));
        // assertNotNull(spliterator.findMethod("~p&~q"));

        // assertArrayEquals(List.of(true, false, false, false).toArray(),
        // spliterator.findMethod("p&q").toArray());
        // assertArrayEquals(List.of(false, false, true, false).toArray(),
        // spliterator.findMethod("~p&q").toArray());
        // assertArrayEquals(List.of(false, true, false, false).toArray(),
        // spliterator.findMethod("p&~q").toArray());
        // assertArrayEquals(List.of(false, false, false, true).toArray(),
        // spliterator.findMethod("~p&~q").toArray());

        // assertArrayEquals(List.of(true, true, true, false).toArray(),
        // spliterator.findMethod("p|q").toArray());
        // assertArrayEquals(List.of(true, false, true, true).toArray(),
        // spliterator.findMethod("~p|q").toArray());
        // assertArrayEquals(List.of(true, true, false, true).toArray(),
        // spliterator.findMethod("p|~q").toArray());
        // assertArrayEquals(List.of(false, true, true, true).toArray(),
        // spliterator.findMethod("~p|~q").toArray());

        // assertArrayEquals(List.of(true, false, true, true).toArray(),
        // spliterator.findMethod("p-q").toArray());
        // assertArrayEquals(List.of(true, true, true, false).toArray(),
        // spliterator.findMethod("~p-q").toArray());
        // assertArrayEquals(List.of(false, true, true, true).toArray(),
        // spliterator.findMethod("p-~q").toArray());
        // assertArrayEquals(List.of(true, true, false, true).toArray(),
        // spliterator.findMethod("~p-~q").toArray());

        // assertArrayEquals(List.of(true, false, false, true).toArray(),
        // spliterator.findMethod("p#q").toArray());
        // assertArrayEquals(List.of(false, true, true, false).toArray(),
        // spliterator.findMethod("~p#q").toArray());
        // assertArrayEquals(List.of(false, true, true, false).toArray(),
        // spliterator.findMethod("p#~q").toArray());
        // assertArrayEquals(List.of(true, false, false, true).toArray(),
        // spliterator.findMethod("~p#~q").toArray());
        // }

        @Test
        void testGetbetween() {
                Spliterators spliterator = new Spliterators();
                assertEquals("q&p", spliterator.getbetween("(q&p)"));
                assertEquals("p", spliterator.getbetween("(p)"));
                assertEquals("q", spliterator.getbetween("(q)"));
                assertEquals("jancok", spliterator.getbetween("(jancok)"));
        }

        @Test
        void testGetPremisAndOperator() {
                Spliterators sp = new Spliterators();
                String[] premisAndOperator = sp.getPremisAndOperator("(~p&q)");
                String[] RESULT = { "~p", "q" };
                // System.out.println(Arrays.asList(premisAndOperator).toString());
                assertArrayEquals(RESULT, premisAndOperator);
        }
}

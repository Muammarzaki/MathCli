package com.logika.helpers.logichelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SpliteratorsTest {
    @Test
    void testGetPremisAndOperator() {
        Spliterators sp = new Spliterators();
        String[] premisAndOperator = sp.getPremisAndOperator("(~p&q)");
        String[] RESULT = { "~p", "q" };

        assertEquals(RESULT, premisAndOperator);
    }
}

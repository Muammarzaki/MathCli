package com.logika.controllers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.logika.constans.Operators;

public class LogicCallerTest {

    @Test
    void testIterateStatment() {
        List<String> parses = List.of("~(p&q)", "|", "(p-q)", "#", "~p");
        LogicCaller logicCaller = new LogicCaller();
        assertArrayEquals(List.of(false, false, true, true).toArray(),
                logicCaller.iterateStatment(parses).toArray());

        // test value 2
        List<String> parses2 = List.of("~(p&q)", "|", "(p-r)");
        LogicCaller logicCaller2 = new LogicCaller();
        // System.out.println(logicCaller2.iterateStatment(parses2));
        assertSame(8,
                logicCaller2.iterateStatment(parses2).size());

        logicCaller.printResult("true", logicCaller2.iterateStatment(parses2));
    }

    @Test
    public void test() {
        System.out.println(
                Arrays.asList(getPremiscoutn("~p")));
    }

    private String[] getPremiscoutn(String str) {
        str = str.replace("(", "").replace(")", "").replace("~", "").trim();
        for (String iterable_element : Operators.OPERATOR) {
            str.replace(iterable_element, " ");
        }
        return str.split(" ");

    }
}
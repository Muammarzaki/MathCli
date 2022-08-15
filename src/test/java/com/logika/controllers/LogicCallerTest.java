package com.logika.controllers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LogicCallerTest {
    @Test
    void testCall() {
        // new CommandLine(new logicCaller()).execute();
    }

    @Test
    void testIterateStatment() {
        List<String> parses = List.of("~(p&q)", "|", "(p-q)", "#", "~p");
        LogicCaller logicCaller = new LogicCaller();
        assertArrayEquals(List.of(false, false, true, true).toArray(),
                logicCaller.iterateStatment(parses).toArray());
        List<String> parses2 = List.of("~(p&q)", "|", "(p-r)");
        LogicCaller logicCaller2 = new LogicCaller();
        System.out.println(logicCaller2.iterateStatment(parses2));
        assertSame(8,
                logicCaller2.iterateStatment(parses2).size());
    }
}
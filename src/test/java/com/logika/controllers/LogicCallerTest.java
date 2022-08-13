package com.logika.controllers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        assertArrayEquals(List.of(false, false, true, true).toArray(), logicCaller.iterateStatment(parses).toArray());
    }
}
package com.logika.controllers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimeTest {
    PrimeCaller prime;

    @Test
    void generatePrimeTest() {
        assertDoesNotThrow(() -> prime.geratingPrimeNumber(100));
    }

    @BeforeEach
    void setUp() {
        prime = new PrimeCaller();
    }

}

package com.library.datastructures.divide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch binarySearch;

    private final List<Integer> input = new ArrayList<>();

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
        for (int i = 0; i < 5; i++) {
            input.add(i);
        }
    }

    @Test
    public void testHasRecursivePositive() {
        boolean has = binarySearch.hasRecursive(input, 3);
        assertTrue(has);

        has = binarySearch.hasRecursive(input, 0);
        assertTrue(has);
    }

    @Test
    public void testHasRecursiveNegative() {
        boolean has = binarySearch.hasRecursive(input, 8);
        assertFalse(has);

        has = binarySearch.hasRecursive(input, -1);
        assertFalse(has);
    }

    @Test
    public void testHasPositive() {
        boolean has = binarySearch.has(input, 3);
        assertTrue(has);

        has = binarySearch.has(input, 0);
        assertTrue(has);
    }

    @Test
    public void testHasNegative() {
        boolean has = binarySearch.has(input, 8);
        assertFalse(has);

        has = binarySearch.has(input, -1);
        assertFalse(has);
    }
}
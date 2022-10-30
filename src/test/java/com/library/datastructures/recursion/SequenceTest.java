package com.library.datastructures.recursion;

import com.library.datastructures.arrays.DynamicArray;
import com.library.datastructures.sets.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {

    private Sequence<Integer> items;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        DynamicArray<Integer> array = new DynamicArray<>();
        for (int i = 0; i < input.length; i++) {
            array.add(i);
        }
        items = new Sequence<>(array);
    }

    @Test
    void testIndex() {
        assertEquals(items.get(0), 0);
        assertEquals(items.get(1), 1);
        assertEquals(items.get(2), 2);
        assertEquals(items.get(3), 3);
        assertEquals(items.get(4), 4);
    }

    @Test
    void testHas() {
        assertTrue(items.has(0));
        assertTrue(items.has(1));
        assertTrue(items.has(2));
        assertTrue(items.has(3));
        assertTrue(items.has(4));
    }

    @Test
    void testHasMultiple() {
        assertTrue(items.hasMultiple(0));
        assertTrue(items.hasMultiple(1));
        assertTrue(items.hasMultiple(2));
        assertTrue(items.hasMultiple(3));
        assertTrue(items.hasMultiple(4));

        assertFalse(items.hasMultiple(5));
        assertFalse(items.hasMultiple(100));
    }

    @Test
    void testMax() {
        assertEquals(items.max(), 4);
        assertNotEquals(items.max(), 1);
    }

    @Test
    void testInsert() {
        items.insert(3, 100);
        assertEquals(items.get(3), 100);
        assertEquals(items.get(4), 3);
    }
}
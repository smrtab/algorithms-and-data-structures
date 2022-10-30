package com.library.datastructures.sets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {

    private HashSet<Integer> hashSet;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        hashSet = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            hashSet.add(i);
        }
    }

    @Test
    void testSize() {
        assertEquals(hashSet.size(), 5);
    }

    @Test
    void testAllValuesAreAdded() {
        int index = 0;
        for (Integer item : hashSet) {
            assertEquals(item, index);
            index++;
        }
    }

    @Test
    void testRemove3Times() {
        hashSet.remove(0);
        assertFalse(hashSet.has(0));
        assertEquals(hashSet.size(), 4);

        hashSet.remove(1);
        assertFalse(hashSet.has(1));
        assertEquals(hashSet.size(), 3);

        hashSet.remove(2);
        assertFalse(hashSet.has(2));
        assertEquals(hashSet.size(), 2);
    }

    @Test
    void testIntersection() {
        int[] inputForIntersection = new int[] {2, 4, 5};
        HashSet<Integer> hashSetForIntersection = new HashSet<>();
        for (int i = 0; i < inputForIntersection.length; i++) {
            hashSetForIntersection.add(inputForIntersection[i]);
        }

        SetADT<Integer> intersection = hashSet.intersection(hashSetForIntersection);
        assertTrue(intersection.has(2));
        assertTrue(intersection.has(4));

        assertFalse(intersection.has(0));
        assertFalse(intersection.has(1));
        assertFalse(intersection.has(3));
        assertFalse(intersection.has(5));
    }

    @Test
    void testUnionAllUnique() {
        int[] inputForUnion = new int[] {5, 6, 7};
        HashSet<Integer> hashSetForUnion = new HashSet<>();
        for (int i = 0; i < inputForUnion.length; i++) {
            hashSetForUnion.add(inputForUnion[i]);
        }
        SetADT<Integer> union = hashSet.union(hashSetForUnion);
        for (int i = 0; i < 8; i++) {
            assertTrue(union.has(i));
        }
        assertEquals(union.size(), 8);
    }

    @Test
    void testUnionNotUnique() {
        int[] inputForUnion = new int[] {3, 4, 5};
        HashSet<Integer> hashSetForUnion = new HashSet<>();
        for (int i = 0; i < inputForUnion.length; i++) {
            hashSetForUnion.add(inputForUnion[i]);
        }
        SetADT<Integer> union = hashSet.union(hashSetForUnion);
        for (int i = 0; i < 6; i++) {
            assertTrue(union.has(i));
        }
        assertEquals(union.size(), 6);
    }

    @Test
    void testDifferenceNonEmptyResult() {
        int[] inputForDifference = new int[] {2, 4, 5};
        HashSet<Integer> hashSetForDifference = new HashSet<>();
        for (int i = 0; i < inputForDifference.length; i++) {
            hashSetForDifference.add(inputForDifference[i]);
        }
        SetADT<Integer> difference = hashSet.difference(hashSetForDifference);
        assertFalse(difference.has(2));
        assertFalse(difference.has(4));
        assertFalse(difference.has(5));

        assertTrue(difference.has(0));
        assertTrue(difference.has(1));
        assertTrue(difference.has(3));

        assertEquals(difference.size(), 3);
    }

    @Test
    void testDifferenceEmptyResult() {
        int[] inputForDifference = new int[] {0, 1, 2, 3, 4};
        HashSet<Integer> hashSetForDifference = new HashSet<>();
        for (int i = 0; i < inputForDifference.length; i++) {
            hashSetForDifference.add(inputForDifference[i]);
        }
        SetADT<Integer> difference = hashSet.difference(hashSetForDifference);
        assertEquals(difference.size(), 0);
    }
}
package com.library.datastructures.divide;

import com.library.datastructures.arrays.DynamicArray;
import com.library.datastructures.recursion.Sequence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecreaseAndConquerTest {

    private DecreaseAndConquer decreaseAndConquer;

    @BeforeEach
    void setUp() {
        decreaseAndConquer = new DecreaseAndConquer();
    }

    @Test
    public void testGreatestCommonDivisor() {
        int gcd = decreaseAndConquer.greatestCommonDivisor(150, 345);
        assertEquals(gcd, 15);
    }

    @Test
    public void testGreatestCommonDivisorNonRecursive() {
        int gcd = decreaseAndConquer.greatestCommonDivisorNonRecursive(150, 345);
        assertEquals(gcd, 15);
    }
}
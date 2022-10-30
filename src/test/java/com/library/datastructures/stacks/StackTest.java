package com.library.datastructures.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> stack;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        stack = new Stack<>(5);
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            stack.push(i);
        }
    }

    @Test
    void testSize() {
        assertEquals(stack.size(), 5);
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = input.length - 1; i == 0; i--) {
            Integer item = stack.pop();
            assertEquals(item, i);
        }
    }

    @Test
    void testPeek3Times() {
        assertEquals(stack.peek(), 4);

        stack.push(100);
        assertEquals(stack.peek(), 100);

        stack.push(200);
        assertEquals(stack.peek(), 200);
    }
}
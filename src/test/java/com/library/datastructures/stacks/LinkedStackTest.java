package com.library.datastructures.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    private LinkedStack<Integer> linkedStack;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        linkedStack = new LinkedStack<>();
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            linkedStack.push(i);
        }
    }

    @Test
    void testSize() {
        assertEquals(linkedStack.size(), 5);
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = input.length - 1; i == 0; i--) {
            Integer item = linkedStack.pop();
            assertEquals(item, i);
        }
    }

    @Test
    void testPeek3Times() {
        assertEquals(linkedStack.peek(), 4);

        linkedStack.push(100);
        assertEquals(linkedStack.peek(), 100);
        assertEquals(linkedStack.size(), 6);

        linkedStack.push(200);
        assertEquals(linkedStack.peek(), 200);
        assertEquals(linkedStack.size(), 7);
    }
}
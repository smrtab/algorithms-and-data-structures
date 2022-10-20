package com.library.datastructures.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue<Integer> arrayQueue;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < input.length; i++) {
            arrayQueue.enqueue(i);
        }
    }

    @Test
    void testSize() {
        assertEquals(arrayQueue.size(), 5);
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = 0; i < input.length; i++) {
            Integer item = arrayQueue.dequeue();
            assertEquals(item, i);
        }
    }

    @Test
    void testDequeue3Times() {
        arrayQueue.dequeue();
        assertEquals(arrayQueue.peek(), 1);

        arrayQueue.dequeue();
        assertEquals(arrayQueue.peek(), 2);

        arrayQueue.dequeue();
        assertEquals(arrayQueue.peek(), 3);

        assertEquals(arrayQueue.size(), 2);
    }
}
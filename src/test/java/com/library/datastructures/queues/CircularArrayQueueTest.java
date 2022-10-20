package com.library.datastructures.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularArrayQueueTest {

    private CircularArrayQueue<Integer> circularArrayQueue;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        circularArrayQueue = new CircularArrayQueue<>();
        for (int i = 0; i < input.length; i++) {
            circularArrayQueue.enqueue(i);
        }
    }

    @Test
    void testSize() {
        assertEquals(circularArrayQueue.size(), 5);
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = 0; i < input.length; i++) {
            Integer item = circularArrayQueue.dequeue();
            assertEquals(item, i);
        }
    }

    @Test
    void testDequeue3Times() {
        circularArrayQueue.dequeue();
        assertEquals(circularArrayQueue.peek(), 1);

        circularArrayQueue.dequeue();
        assertEquals(circularArrayQueue.peek(), 2);

        circularArrayQueue.dequeue();
        assertEquals(circularArrayQueue.peek(), 3);

        assertEquals(circularArrayQueue.size(), 2);
    }
}
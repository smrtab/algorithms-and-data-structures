package com.library.datastructures.queues;

import com.library.datastructures.linkedlists.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    private LinkedQueue<Integer> linkedQueue;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < input.length; i++) {
            linkedQueue.enqueue(i);
        }
    }

    @Test
    void testSize() {
        assertEquals(linkedQueue.size(), 5);
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = 0; i < input.length; i++) {
            Integer item = linkedQueue.dequeue();
            assertEquals(item, i);
        }
    }

    @Test
    void testDequeue3Times() {
        linkedQueue.dequeue();
        assertEquals(linkedQueue.peek(), 1);

        linkedQueue.dequeue();
        assertEquals(linkedQueue.peek(), 2);

        linkedQueue.dequeue();
        assertEquals(linkedQueue.peek(), 3);

        assertEquals(linkedQueue.size(), 2);
    }
}
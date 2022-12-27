package com.library.datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    private MinHeap<Integer, String> heap;

    @BeforeEach
    void setUp() {
        heap = new MinHeap<>();
        heap.set(0, "a");
        heap.set(1, "b");
        heap.set(2, "c");
        heap.set(3, "d");
        heap.set(4, "e");
    }

    @Test
    public void testDequeue() {
        List<Integer> items = new ArrayList<>();
        int index = 0;
        while (items.size() > 0) {
            int key = heap.dequeue().getKey();
            items.add(key);
            assertEquals(index, key);
            index++;
        }
    }
}
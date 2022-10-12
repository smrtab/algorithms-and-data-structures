package com.library.datastructures.queues;

import com.library.datastructures.arrays.DynamicArray;

public class ArrayQueue<T> implements QueueADT<T> {

    private final DynamicArray<T> items;

    public ArrayQueue() {
        items = new DynamicArray<>();
    }

    @Override
    public void enqueue(T value) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }
}

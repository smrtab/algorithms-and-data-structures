package com.library.datastructures.queues;

import com.library.datastructures.arrays.DynamicArray;

public class ArrayQueue<T> implements QueueADT<T> {

    private final DynamicArray<T> items;

    public ArrayQueue() {
        items = new DynamicArray<>();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public void enqueue(T value) {
        items.append(value);
    }

    @Override
    public T dequeue() {
        T item = items.get(0);
        items.remove(0);
        return item;
    }

    @Override
    public T peek() {
        return items.get(0);
    }
}

package com.library.datastructures.queues;

import com.library.datastructures.arrays.StaticArray;

public class CircularArrayQueue<T> implements QueueADT<T> {

    protected static final int CAPACITY = 10;

    private final int capacity;

    private int start;

    private int end = 0;

    private int size = 0;

    private final StaticArray<T> items;

    public CircularArrayQueue() {
        this(CAPACITY);
    }

    public CircularArrayQueue(int capacity) {
        items = new StaticArray<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T value) {
        if (isFull()) {
            throw new RuntimeException("The queue is full.");
        }
        items.set(end, value);
        end = (end + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        T value = items.remove(start);
        start = (start + 1) % capacity;
        size--;
        return value;
    }

    @Override
    public T peek() {
        return items.get(start);
    }

    public boolean isFull() {
        return size == capacity;
    }
}

package com.library.datastructures.queues;

import com.library.datastructures.arrays.StaticArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CircularArrayQueue<T> implements QueueADT<T> {

    protected static final int CAPACITY = 10;

    private final int capacity;

    private int start;

    private int end = 0;

    private int size = 0;

    private final T[] items;

    public CircularArrayQueue() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T value) {
        if (isFull()) {
            throw new RuntimeException("The queue is full.");
        }
        items[end] = value;
        end = (end + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        T value = items[start];
        items[start] = null;
        start = (start + 1) % capacity;
        size--;
        return value;
    }

    @Override
    public T peek() {
        return items[start];
    }

    public boolean isFull() {
        return size == capacity;
    }
}

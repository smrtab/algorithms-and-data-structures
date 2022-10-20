package com.library.datastructures.queues;

public interface QueueADT<T> {
    int size();
    void enqueue(T value);
    T dequeue();
    T peek();
}
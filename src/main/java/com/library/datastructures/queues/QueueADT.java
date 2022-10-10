package com.library.datastructures.queues;

public interface QueueADT<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
}
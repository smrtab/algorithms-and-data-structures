package com.library.datastructures.priorityqueues;

public interface PriorityQueueADT<T, E extends Comparable<E>> {
    void enqueue(T item, E priority);
    T dequeue();
    T peek();
}

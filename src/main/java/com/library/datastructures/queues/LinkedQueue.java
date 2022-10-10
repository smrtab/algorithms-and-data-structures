package com.library.datastructures.queues;

import com.library.datastructures.linkedlists.LinkedList;

public class LinkedQueue<T> implements QueueADT<T> {

    private final LinkedList<T> linkedList;

    public LinkedQueue() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void enqueue(T value) {
        linkedList.append(value);
    }

    @Override
    public T dequeue() {
        return linkedList.popFirst();
    }

    @Override
    public T peek() {
        return linkedList.get(0);
    }

    @Override
    public String toString() {
        return "LinkedQueue [" +
            "linkedList: " + linkedList +
            "]";
    }
}

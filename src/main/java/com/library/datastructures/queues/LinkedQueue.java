package com.library.datastructures.queues;

import com.library.datastructures.linkedlists.SinglyLinkedList;

public class LinkedQueue<T> implements QueueADT<T> {

    private final SinglyLinkedList<T> singlyLinkedList;

    public LinkedQueue() {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Override
    public void enqueue(T value) {
        singlyLinkedList.append(value);
    }

    @Override
    public T dequeue() {
        return singlyLinkedList.popFirst();
    }

    @Override
    public T peek() {
        return singlyLinkedList.get(0);
    }

    @Override
    public String toString() {
        return "LinkedQueue [" +
            "linkedList: " + singlyLinkedList +
            "]";
    }
}

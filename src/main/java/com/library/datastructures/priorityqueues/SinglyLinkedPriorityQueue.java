package com.library.datastructures.priorityqueues;

import com.library.datastructures.linkedlists.SinglyLinkedList;

import java.util.Iterator;

public class SinglyLinkedPriorityQueue<T, E extends Comparable<E>>
    implements PriorityQueueADT<T, E> {

    private final SinglyLinkedList<Node<T, E>> linkedList;

    public SinglyLinkedPriorityQueue() {
        linkedList = new SinglyLinkedList<>();
    }

    @Override
    public void enqueue(T item, E priority) {

        Node<T, E> node = new Node<>(item, priority);

        int index = 0;
        int position = -1;

        Iterator<Node<T, E>> it = linkedList.iterator();
        while (it.hasNext() && position == -1) {
            Node<T, E> current = it.next();
            if (current.getPriority().compareTo(node.getPriority()) < 0) {
                position = index;
            } else {
                index++;
            }
        }

        position = position > -1 ? position : 0;
        linkedList.insert(position, node);
    }

    @Override
    public T dequeue() {
        return linkedList.popFirst().getItem();
    }

    @Override
    public T peek() {
        return linkedList.get(0).getItem();
    }

    @Override
    public String toString() {
        return "SinglyLinkedPriorityQueue [" +
            "linkedList: " + linkedList +
            "]";
    }

    private static class Node<T, E extends Comparable<E>> {
        private T item;
        private E priority;

        Node(T item, E priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public E getPriority() {
            return priority;
        }

        public void setPriority(E priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Node [" +
                "item: " + item +
                ", priority: " + priority +
                "]";
        }
    }
}

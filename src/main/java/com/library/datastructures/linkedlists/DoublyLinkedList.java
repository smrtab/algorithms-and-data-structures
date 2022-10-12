package com.library.datastructures.linkedlists;

import com.library.datastructures.arrays.StaticArray;

public class DoublyLinkedList<V> implements LinkedListADT<V> {

    private Node<V> head;

    private Node<V> tail;

    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns value of the node located at the given index
     * @param index index of the node
     * @return V
     */
    public V get(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<V> current = find(index);

        return current != null
                ? current.getValue()
                : null;
    }

    /**
     * Replaces value of the node at the given index.
     * @param   index   index of the node
     * @param   value   value to replace with
     */
    public void set(int index, V value) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<V> current = find(index);
        current.setValue(value);
    }

    /**
     * Append value to the sequence.
     * O(1) since it directly uses the tail
     *
     * Operation: append
     * Inputs/Outputs: list, a doubly linked list
     * Input: value, object
     * Preconditions: true
     * Postconditions: value is the tail of the linked list
     *
     * @param   value   value to append
     */
    public void append(V value) {
        Node<V> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Removes and returns the first value to the sequence.
     * O(1) since it directly uses the head
     *
     * Operation: pop first value
     * Inputs/Outputs: list, a linked list
     * Input: none
     * Preconditions: 0 < |linked list|
     * Output: value, object
     * Postconditions: value is the first value of the linked list,
     */
    public V popFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        Node<V> node = head;
        head = head.getNext();
        return node.getValue();
    }

    /**
     * Inserts a new node into the given index.
     * @param   index   index of placement
     * @param   value   value to insert
     */
    public void insert(int index, V value) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<V> node = new Node<>(value);
        if (index == 0) {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        } else {
            Node<V> next = find(index);
            node.setNext(next);
            node.setPrevious(next.getPrevious());
            next.getPrevious().setNext(node);
            next.setPrevious(node);
        }
        size++;
    }

    /**
     * Removes the node at the given index
     * @param   index   index of the node to be removed
     */
    public void remove(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.getNext();
            head.setPrevious(null);
        } else {
            Node<V> node = find(index);
            node.getPrevious().setNext(node.getNext());

            if (node.getNext() == null) {
                tail = node.getPrevious();
            } else {
                node.getNext().setPrevious(node.getPrevious());
            }
        }
        size--;
    }

    /**
     * Finds a node in the linked list
     * @param   index   an index to locate the node
     * @return  node    the node located at the given index
     */
    private Node<V> find(int index) {
        int middle = size / 2;
        Node<V> node;
        if (index > middle) {
            node = tail;
            int pointer = size - 1;
            while (pointer > index) {
                node = node.getPrevious();
                pointer--;
            }
        } else {
            node = head;
            int pointer = 0;
            while (pointer < index) {
                node = node.getNext();
                pointer++;
            }
        }
        return node;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList [" +
                "head: " + head.getValue() +
                ", tail: " + tail.getValue() +
                ", size: " + size +
                ", items: " + toArray() +
                "]";
    }

    public StaticArray<V> toArray() {
        StaticArray<V> staticArray = new StaticArray<>(size);
        Node<V> current = head;
        while (current != null) {
            staticArray.add(current.getValue());
            current = current.getNext();
        }
        return staticArray;
    }

    public static class Node<V> {

        private V value;

        private Node<V> next;

        private Node<V> previous;

        public Node(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<V> getNext() {
            return next;
        }

        public void setNext(Node<V> next) {
            this.next = next;
        }

        public Node<V> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<V> previous) {
            this.previous = previous;
        }
    }
}

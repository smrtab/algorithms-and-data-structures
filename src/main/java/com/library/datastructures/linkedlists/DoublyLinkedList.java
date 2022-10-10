package com.library.datastructures.linkedlists;

public class DoublyLinkedList<V> {

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

        Node<V> current = head;
        int pointer = 0;
        while (pointer < index) {
            current = current.getNext();
            pointer++;
        }

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

        Node<V> current = head;
        int pointer = 0;
        while (pointer < index) {
            current = current.getNext();
            pointer++;
        }

        current.setValue(value);
    }

    /**
     * Append value to the sequence.
     * O(1) since it directly uses the tail
     *
     * Operation: append
     * Inputs/Outputs: list, a linked list
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
            head = node;
        } else {
            Node<V> before = head;
            int pointer = 0;
            while (pointer < index - 1) {
                before = before.getNext();
                pointer++;
            }
            node.setNext(before.getNext());
            before.setNext(node);
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
        } else {
            Node<V> before = head;
            int pointer = 0;
            while (pointer < index - 1) {
                before = before.getNext();
                pointer++;
            }
            before.setNext(before.getNext().getNext());

            if (before.getNext() == null) {
                tail = before;
            }
        }
        size--;
    }

    @Override
    public String toString() {
        return "LinkedList [" +
                "head: " + head.getValue() +
                ", tail=" + tail.getValue() +
                ", size=" + size +
                "]";
    }
}

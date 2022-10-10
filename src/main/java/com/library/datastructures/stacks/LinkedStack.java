package com.library.datastructures.stacks;

import com.library.datastructures.linkedlists.LinkedList;

public class LinkedStack<T> implements StackADT<T> {

    private final LinkedList<T> items;

    public LinkedStack() {
        items = new LinkedList<>();
    }

    /**
     * Operation: push
     * Inputs/Outputs: items, a stack
     * Inputs: value, object
     * Preconditions: true
     * Postconditions: post-values = pre-values[0] ... pre-values[|items| - 1], value
     * @param   value   value to push on the top of the stack
     */
    @Override
    public void push(T value) {
        items.insert(0, value);
    }

    /**
     * Operation: pop
     * Inputs/Outputs: items, a stack
     * Inputs: none
     * Preconditions: 0 < |items|
     * Output: value, object
     * Postconditions: post-values = pre-values[0] ... pre-values[|items| - 2]
     */
    @Override
    public T pop() {
        T value = items.get(0);
        items.remove(0);
        return value;
    }

    /**
     * Function: pop
     * Inputs: items, a stack
     * Preconditions: 0 < |items|
     * Output: value, object
     * Postconditions: value is the last object in the stack, value = items[|items| - 1]
     */
    @Override
    public T peek() {
        return items.get(0);
    }

    public int getSize() {
        return items.getSize();
    }

    @Override
    public String toString() {
        return "LinkedStack [" +
                "items: " + items +
                "]";
    }
}

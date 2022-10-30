package com.library.datastructures.stacks;

import com.library.datastructures.arrays.DynamicArray;

public class Stack<T> implements StackADT<T> {

    protected static final int CAPACITY = 10;

    private final DynamicArray<T> items;

    public Stack() {
        this(CAPACITY);
    }

    public Stack(int capacity) {
        items = new DynamicArray<>(capacity);
    }

    @Override
    public int size() {
        return items.size();
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
        items.add(value);
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
        return items.remove(items.size() - 1);
    }

    /**
     * Function: peek
     * Inputs: items, a stack
     * Preconditions: 0 < |items|
     * Output: value, object
     * Postconditions: value is the last object in the stack, value = items[|items| - 1]
     */
    @Override
    public T peek() {
        return items.get(items.size() - 1);
    }

    public int getSize() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Stack [" +
            "items: " + items +
            "]";
    }
}

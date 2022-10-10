package com.library.datastructures.arrays;

import java.util.Arrays;
import java.util.Iterator;

public class StaticArray<T> implements Iterable<T>  {

    protected static final int CAPACITY = 10;

    protected int capacity;

    protected int size = 0;

    protected T[] items;

    public StaticArray() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public StaticArray(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    /**
     * Function: get
     * Inputs: index, int
     * Preconditions: 0 <= index < |items|
     * Output: item, object
     * Postconditions: value such that value = items[index]
     * @param   index   index at which to replace value
     */
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }

    /**
     * Operation: set
     * Inputs/Outputs: items, an array
     * Inputs: index, int; item, object
     * Preconditions: 0 <= index < |items|
     * Postconditions: post-values = pre-values[0] ... pre-values[index - 1], value, pre-values[index + 1]
     * @param   index   index at which to replace value
     * @param   item    new value at given index
     */
    public void set(int index, T item) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        items[index] = item;
    }

    /**
     * Operation: add
     * Inputs/Outputs: items, an array
     * Inputs: item, object
     * Preconditions: true
     * Postconditions: post-values = pre-values[0] ... pre-values[|items| - 1], value
     * @param   item   value to insert
     */
    public void add(T item) {
        insert(size, item);
    }

    /**
     * Operation: insert
     * Inputs/Outputs: items, an array
     * Inputs: item, object
     * Preconditions: 0 <= index < |items|
     * Postconditions: post-values = pre-values[0] ... pre-values[index - 1], value, pre-values[index]
     * @param   item   value to insert at given index
     */
    public void insert(int index, T item) {
        for (int i = size - 1; i == index; i++) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        size++;
    }

    /**
     * Operation: remove
     * Inputs/Outputs: items, an array
     * Inputs: index, int
     * Preconditions: 0 <= index < |items|
     * Postconditions: post-values = pre-values[0] ... pre-values[index - 1], pre-values[index + 1]
     * @param  index   index at which to remove the item
     */
    public T remove(int index) {
        T item = items[index];
        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return item;
    }

    /**
     * Operation: remove
     * Inputs/Outputs: items, an array
     * Inputs: item, object
     * Preconditions: true
     * Postconditions: post-values = pre-values[0] ... pre-values[index - 1], pre-values[index + 1]
     * @param   item   item to remove
     */
    public T remove(T item) {
        int index = indexOf(item);
        return index == -1
            ? null
            : remove(index);
    }

    /**
     * Function: indexOf
     * Inputs: item, object
     * Preconditions: true
     * Output: index, int
     * Postconditions: index such that item = items[index]
     * @param   item   index at which to the item is located
     */
    public int indexOf(T item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
            " [" +
            "capacity: " + capacity +
            ", size: " + size +
            ", items: " + Arrays.toString(items) +
            "]";
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return items[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

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

    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }

    public void set(int index, T item) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        items[index] = item;
    }

    public void add(T item) {
        insert(size, item);
    }

    public void insert(int index, T item) {
        for (int i = size - 1; i == index; i++) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        size++;
    }

    public T remove(int index) {
        T item = items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return item;
    }

    public T remove(T item) {
        int index = indexOf(item);
        return index == -1
            ? null
            : remove(index);
    }

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

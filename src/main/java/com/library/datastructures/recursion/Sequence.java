package com.library.datastructures.recursion;

import com.library.datastructures.arrays.DynamicArray;

import java.util.Comparator;

public class Sequence<T extends Comparable<T>> {

    private final DynamicArray<T> items;

    private final Recursion recursion;

    public Sequence(DynamicArray<T> items) {
        this.items = items;
        this.recursion = new Recursion();
    }

    public T get(int index) {
        return recursion.get(index, 0, items.size());
    }


    public void insert(int index, T item) {
        recursion.insert(index, item,0, items.size());
    }

    public void append(T item) {
        recursion.append(item, 0, items.size());
    }

    public boolean has(T item) {
        return recursion.has(item, 0, items.size());
    }

    public boolean hasMultiple(T item) {
        return recursion.hasMultiple(item, 0, items.size());
    }

    public T max() {
        return recursion.max(0, items.size());
    }

    private class Recursion {

        private T get(int index, int start, int end) {
            if (index == 0) {
                return items.get(start);
            } else {
                return get(index - 1, start + 1, end);
            }
        }

        private void insert(int index, T item, int start, int end) {
            if (index == 0 || start == end) {
                items.insert(start, item);
            } else {
                insert(index - 1, item, start + 1, end);
            }
        }

        private void append(T item, int start, int end) {
            if (start == end) {
                items.insert(start, item);
            } else {
                append(item, start + 1, end);
            }
        }

        private boolean has(T item, int start, int end) {
            if (start == end) {
                return false;
            } else if (items.get(start).equals(item)) {
                return true;
            } else {
                return has(item, start + 1, end);
            }
        }

        private boolean hasMultiple(T item, int start, int end) {
            if (start == end) {
                return false;
            } else if (start + 1 == end) {
                return items.get(start).equals(item);
            } else {
                int middle = start + (int) Math.floor((end - start) / 2);
                boolean hasInLeft = hasMultiple(item, 0, middle);
                boolean hasInRight = hasMultiple(item, middle, end);
                return hasInLeft || hasInRight;
            }
        }

        private T max(int start, int end) {
            if (start + 1 == end) {
                return items.get(start);
            } else {
                return maximum(items.get(start), max(start + 1, end));
            }
        }

        private T maximum(T left, T right) {
            return left.compareTo(right) >= 0 ? left : right ;
        }
    }
}

package com.library.datastructures.arrays;

public class DynamicArray<T> extends StaticArray<T> {

    private static final double THRESHOLD = 0.75;

    private final double threshold;

    public DynamicArray() {
        this(CAPACITY, THRESHOLD);
    }

    public DynamicArray(int capacity) {
        this(capacity, THRESHOLD);
    }

    public DynamicArray(int capacity, double threshold) {
        super(capacity);
        this.threshold = threshold;
    }

    @Override
    public void insert(int index, T item) {
        super.insert(index, item);
        adjust();
    }

    @SuppressWarnings("unchecked")
    private void adjust() {
        double usedUpCapacity = capacity * threshold;
        if (usedUpCapacity <= size) {
            capacity = capacity * 2;
            T[] newItems = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }
}

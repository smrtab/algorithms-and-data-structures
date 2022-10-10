package com.library.datastructures.hashtables;

import com.library.datastructures.arrays.DynamicArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class HashTableSeparateChaining<K, V> implements Iterable<K> {

    protected static final int CAPACITY = 10;

    private static final double THRESHOLD = 0.75;

    protected int capacity;

    private final double threshold;

    protected int size = 0;

    private DynamicArray<Entry<K, V>>[] items;

    public HashTableSeparateChaining() {
        this(CAPACITY, THRESHOLD);
    }

    @SuppressWarnings("unchecked")
    public HashTableSeparateChaining(int capacity, double threshold) {
        items = (DynamicArray<Entry<K, V>>[]) Array.newInstance(DynamicArray.class, capacity);
        this.threshold = threshold;
        this.capacity = capacity;
    }

    private int normalizeKey(K key) {
        return key.hashCode() % capacity;
    }

    public void add(K key, V value) {

        int hashTableIndex = normalizeKey(key);
        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];
        if (bucket == null) {
            bucket = new DynamicArray<>(1);
            items[hashTableIndex] = bucket;
            size++;
        }

        Entry<K, V> entry = new Entry<>(key, value);

        int bucketIndex = bucket.indexOf(entry);
        if (bucketIndex == -1) {
            bucket.add(entry);
        } else {
            bucket.set(bucketIndex, entry);
        }

        adjust();
    }

    public V get(K key) {
        int hashTableIndex = normalizeKey(key);
        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];

        Entry<K, V> result = null;
        int index = 0;
        while (result == null && index < bucket.getSize()) {
            if (bucket.get(index).getKey().equals(key)) {
                result = bucket.get(index);
            }
            index++;
        }

        return result != null ? result.getValue() : null;
    }

    @SuppressWarnings("unchecked")
    private void adjust() {
        double usedUpCapacity = capacity * threshold;
        if (usedUpCapacity <= size) {
            capacity = capacity * 2;
            DynamicArray<Entry<K, V>>[] newItems = (DynamicArray<Entry<K, V>>[]) Array.newInstance(DynamicArray.class, capacity);
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    @Override
    public String toString() {
        return "HashTableSeparateChaining [" +
                "capacity: " + capacity +
                ", size: " + size +
                ", items: " + Arrays.toString(items) +
                "]";
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public K next() {
                return items[0].get(0).getKey();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

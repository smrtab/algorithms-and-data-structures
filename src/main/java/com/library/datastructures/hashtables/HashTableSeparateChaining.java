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
        }

        Entry<K, V> entry = new Entry<>(key, value);

        int bucketIndex = bucket.indexOf(entry);
        if (bucketIndex == -1) {
            bucket.add(entry);
            size++;
        } else {
            bucket.set(bucketIndex, entry);
        }

        adjust();
    }

    public V get(K key) {
        int hashTableIndex = normalizeKey(key);
        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];

        Entry<K, V> result = null;
        if (bucket != null) {
            int index = 0;
            while (result == null && index < bucket.getSize()) {
                if (bucket.get(index).getKey().equals(key)) {
                    result = bucket.get(index);
                }
                index++;
            }
        }

        return result != null ? result.getValue() : null;
    }

    /**
     * Operation: remove.
     * Inputs/Outputs: items, a hashtable
     * Input: key, an object
     * Preconditions: true
     * Output: value, an object
     * Postconditions: post-values
     * @param   key a key associated with a value to delete.
     * @return  value  removed value or null
     */
    public V remove(K key) {
        int hashTableIndex = normalizeKey(key);
        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];

        int bucketIndex = -1;
        if (bucket != null) {
            int index = 0;
            while (bucketIndex == -1 && index < bucket.getSize()) {
                if (bucket.get(index).getKey().equals(key)) {
                    bucketIndex = index;
                } else {
                    index++;
                }
            }
        }

        V result = null;
        if (bucketIndex != -1) {
            result = bucket.remove(bucketIndex).getValue();
            if (bucket.getSize() == 0) {
                items[hashTableIndex] = null;
            }
            size--;
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    private void adjust() {
        double usedUpCapacity = capacity * threshold;
        if (usedUpCapacity <= items.length) {
            capacity = capacity * 2;
            DynamicArray<Entry<K, V>>[] newItems = (DynamicArray<Entry<K, V>>[]) Array.newInstance(DynamicArray.class, capacity);
            for (int i = 0; i < items.length; i++) {
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

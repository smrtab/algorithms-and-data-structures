package com.library.datastructures.hashtables;

import com.library.datastructures.arrays.DynamicArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

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

    public int size() {
        return items.length;
    }

    private int normalizeKey(int hashCode) {
        return hashCode % capacity;
    }

    /**
     * Operation: add.
     * Inputs/Outputs: items, a hashtable
     * Input: key, an object; value, an object
     * Preconditions: key is hashable
     * Output: None
     * Postconditions: lookup the key returns the value
     *
     * @param   key     a key associated with a value.
     * @param   value   a value to be searched by a key.
     */
    public void add(K key, V value) {

        Entry<K, V> entry = new Entry<>(key, value);
        int hashTableIndex = normalizeKey(entry.getHash());

        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];
        if (bucket == null) {
            bucket = new DynamicArray<>(1);
            items[hashTableIndex] = bucket;
        }

        int bucketIndex = bucket.indexOf(entry);
        if (bucketIndex == -1) {
            bucket.add(entry);
            size++;
        } else {
            bucket.set(bucketIndex, entry);
        }

        adjust();
    }

    /**
     * Function: get.
     * Input: key, an object
     * Preconditions: key is hashable
     * Output: value, an object
     * Postconditions: value is an object associated with the given key
     *
     * @param   key     a key associated with a value.
     * @return  value   required value or null
     */
    public V get(K key) {
        int hashTableIndex = normalizeKey(key.hashCode());
        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];

        int bucketIndex = findBucketIndex(key, bucket);

        return bucketIndex != -1
            ? bucket.get(bucketIndex).getValue()
            : null;
    }

    /**
     * Operation: remove.
     * Inputs/Outputs: items, a hashtable
     * Input: key, an object
     * Preconditions: key is hashable
     * Output: value, an object
     * Postconditions: lookup the key returns null
     *
     * @param   key     a key associated with a value to delete.
     * @return  value   removed value or null
     */
    public V remove(K key) {
        int hashTableIndex = normalizeKey(key.hashCode());
        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];

        int bucketIndex = findBucketIndex(key, bucket);

        V result = null;
        if (bucketIndex != -1) {
            result = bucket.remove(bucketIndex).getValue();
            if (bucket.size() == 0) {
                items[hashTableIndex] = null;
            }
            size--;
        }

        return result;
    }

    /**
     * Function: hasKey.
     * Input: key, an object
     * Preconditions: key is hashable
     * Output: value, a boolean
     * Postconditions: true iff the hashable contains the key
     *
     * @param   key     a key associated with a value.
     * @return  value   whether the key is in the hash table
     */
    public boolean hasKey(K key) {
        int hashTableIndex = normalizeKey(key.hashCode());
        DynamicArray<Entry<K, V>> bucket = items[hashTableIndex];
        return findBucketIndex(key, bucket) != -1;
    }

    private int findBucketIndex(K key, DynamicArray<Entry<K, V>> bucket) {
        int bucketIndex = -1;
        if (bucket != null) {
            int index = 0;
            while (bucketIndex == -1 && index < bucket.size()) {
                if (bucket.get(index).getKey().equals(key)) {
                    bucketIndex = index;
                } else {
                    index++;
                }
            }
        }
        return bucketIndex;
    }

    @SuppressWarnings("unchecked")
    private void adjust() {
        double loadFactor = (double) size / items.length;
        if (loadFactor >= threshold) {
            capacity = capacity * 2;
            DynamicArray<Entry<K, V>>[] newItems = (DynamicArray<Entry<K, V>>[]) Array.newInstance(DynamicArray.class, capacity);
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    for (Entry<K, V> entry : items[i]) {
                        int index = normalizeKey(entry.getHash());
                        DynamicArray<Entry<K, V>> bucket = newItems[index];
                        if (bucket == null) {
                            newItems[index] = new DynamicArray<>();
                        }
                        newItems[index].add(entry);
                    }
                }
                items[i] = null;
            }
            items = newItems;
        }
    }

    @Override
    public String toString() {
        return "HashTableSeparateChaining ["
                + capacity + " / " + size
                + ", " + Arrays.toString(items) +
                "]";
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<>() {
            DynamicArray<Entry<K, V>> bucket = null;
            int tableIndex = 0;
            int bucketIndex = 0;

            @Override
            public boolean hasNext() {
                while (bucket == null && tableIndex < items.length) {
                    bucket = items[tableIndex++];
                }

                if (bucket == null) {
                    return false;
                }

                if (bucketIndex >= bucket.size()) {
                    bucket = null;
                    bucketIndex = 0;
                    return hasNext();
                }  else {
                    return bucketIndex < bucket.size();
                }
            }

            @Override
            public K next() {
                return bucket.get(bucketIndex++).getKey();
            }

            @Override
            public void remove() {
                bucketIndex--;
                bucket.remove(bucketIndex);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super K> action) {
        for (K k : this) {
            action.accept(k);
        }
    }

    private static class Entry<K, V> {

        private final K key;

        private final V value;

        private final int hash;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public int getHash() {
            return hash;
        }

        @Override
        public String toString() {
            return key + " => " + value;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry<K, V> other = (Entry<K, V>) obj;
            return key.equals(other.getKey());
        }
    }
}

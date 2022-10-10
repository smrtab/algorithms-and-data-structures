package com.library.datastructures.hashtables;

public class Entry<K, V> {

    private final K key;

    private final V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Entry [" +
            "key: " + key +
            ", value: " + value +
            "]";
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

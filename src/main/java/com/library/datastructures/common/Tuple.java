package com.library.datastructures.common;

public class Tuple<K, T> {

    private final K key;
    private final T value;

    public Tuple(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}

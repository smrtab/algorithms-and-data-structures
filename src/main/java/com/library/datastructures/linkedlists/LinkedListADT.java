package com.library.datastructures.linkedlists;

public interface LinkedListADT<V> {
    V get(int index);
    void set(int index, V item);
    void append(V item);
    void insert(int index, V item);
    void remove(int index);
}

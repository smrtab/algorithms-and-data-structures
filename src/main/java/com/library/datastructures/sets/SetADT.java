package com.library.datastructures.sets;

import com.library.datastructures.arrays.DynamicArray;

public interface SetADT<T> extends Iterable<T> {
    void add(T item);
    void remove(T item);
    boolean has(T item);
    int size();
    DynamicArray<T> toArray();
    SetADT<T> union(SetADT<T> right);
    SetADT<T> intersection(SetADT<T> right);
    SetADT<T> difference(SetADT<T> right);
}

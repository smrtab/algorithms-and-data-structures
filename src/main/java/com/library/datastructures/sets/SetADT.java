package com.library.datastructures.sets;

public interface SetADT<T> extends Iterable<T> {
    void add(T item);
    void remove(T item);
    boolean has(T item);
    int size();
    SetADT<T> union(SetADT<T> right);
    SetADT<T> intersection(SetADT<T> right);
    SetADT<T> difference(SetADT<T> right);
}

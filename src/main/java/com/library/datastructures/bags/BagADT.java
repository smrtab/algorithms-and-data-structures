package com.library.datastructures.bags;

import com.library.datastructures.sets.SetADT;

public interface BagADT<T> extends Iterable<T> {
    int size();
    void add(T item);
    void remove(T item);
    boolean has(T item);
    BagADT<T> union(BagADT<T> right);
    BagADT<T> intersection(BagADT<T> right);
    BagADT<T> difference(BagADT<T> right);
    int multiplicity(T item);
}

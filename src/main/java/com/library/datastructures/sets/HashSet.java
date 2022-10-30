package com.library.datastructures.sets;

import com.library.datastructures.arrays.DynamicArray;
import com.library.datastructures.hashtables.HashTableSeparateChaining;

import java.util.Iterator;
import java.util.function.Consumer;

public class HashSet<T> implements SetADT<T> {

    private final static Object DUMMY = new Object();

    private final HashTableSeparateChaining<T, Object> set;

    public HashSet() {
        set = new HashTableSeparateChaining<>();
    }

    public HashSet(T item) {
        this();
        add(item);
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.size() == 0;
    }

    /**
     * Operation: remove.
     * Inputs/Outputs: items, a hashtable
     * Input: key, an object
     * Preconditions: key is hashable
     * Output: value, an object
     * Postconditions: lookup the key returns null
     *
     * @param   item    a key associated with a value to delete.
     */
    @Override
    public void add(T item) {
        set.add(item, DUMMY);
    }

    @Override
    public void remove(T item) {
        set.remove(item);
    }

    @Override
    public boolean has(T item) {
        return set.hasKey(item);
    }

    @Override
    public SetADT<T> union(SetADT<T> right) {
        SetADT<T> newSet = new HashSet<>();
        for (T item : this) {
            newSet.add(item);
        }
        for (T item : right) {
            newSet.add(item);
        }
        return newSet;
    }

    @Override
    public SetADT<T> intersection(SetADT<T> right) {

        SetADT<T> newSet = new HashSet<>();
        SetADT<T> smallerSet, biggerSet;

        if (right.size() < this.size()) {
            smallerSet = right;
            biggerSet = this;
        } else {
            smallerSet = this;
            biggerSet = right;
        }

        for (T item : smallerSet) {
            if (biggerSet.has(item)) {
                newSet.add(item);
            }
        }

        return newSet;
    }

    @Override
    public SetADT<T> difference(SetADT<T> right) {
        SetADT<T> newSet = new HashSet<>();
        for (T item : this) {
            if (!right.has(item)) {
                newSet.add(item);
            }
        }
        return newSet;
    }

    @Override
    public String toString() {
        return "HashSet ["
            + ", " + set +
            "]";
    }

    @Override
    public DynamicArray<T> toArray() {
        DynamicArray<T> list = new DynamicArray<>();
        for (T item : this) {
            list.add(item);
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = set.iterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next();
            }

            @Override
            public void remove() {
                iterator.remove();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T t : this) {
            action.accept(t);
        }
    }
}

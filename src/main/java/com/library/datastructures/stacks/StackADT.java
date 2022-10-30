package com.library.datastructures.stacks;

public interface StackADT<T> {
    int size();
    void push(T value);
    T pop();
    T peek();
}

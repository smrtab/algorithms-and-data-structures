package com.library.datastructures.stacks;

public interface StackADT<T> {
    void push(T value);
    T pop();
    T peek();
}

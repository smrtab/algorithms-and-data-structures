package com.library.datastructures.trees;

import java.util.List;

interface BinaryTreeADT<T> {
    T root();
    boolean isEmpty();
    boolean isLeaf();
    boolean has(T item);
    BinaryTreeADT<T> left();
    BinaryTreeADT<T> right();
    int size();
    String infix();
    void postfix();
    List<T> breadthFirstSearch();
}

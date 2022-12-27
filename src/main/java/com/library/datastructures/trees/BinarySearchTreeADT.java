package com.library.datastructures.trees;

import java.util.List;

public interface BinarySearchTreeADT<K extends Comparable<K>, V>{
    V get(K key);
    void set(K key, V value);
    void set(K key, V value, int level);
    void remove(K key);
    boolean hasKey(K key);
    TreeNode<K, V> root();
    boolean isEmpty();
    boolean isLeaf();
    boolean isBalanced();
    BinarySearchTreeADT<K, V> left();
    BinarySearchTreeADT<K, V> right();
    int size();
    int height();
    TreeNode<K, V> smallest();
}

package com.library.datastructures.trees;

public interface BinarySearchTreeADT<K, V>{
    V get(K key);
    void set(K key, V value);
    void remove(K key);
    boolean has(K key);
    TreeNode<K, V> root();
}

package com.library.datastructures.trees;

public class TreeNode<K, V> {

    private K key;
    private V value;
    private int level;

    public TreeNode(K key, V value) {
        this(key, value, 0);
    }

    public TreeNode(K key, V value, int level) {
        this.key = key;
        this.value = value;
        this.level = level;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

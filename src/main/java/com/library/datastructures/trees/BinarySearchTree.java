package com.library.datastructures.trees;

public class BinarySearchTree<K extends Comparable<K>, V>
        extends BinaryTree<TreeNode<K, V>>
        implements BinarySearchTreeADT<K, V> {

    private TreeNode<K, V> root;
    private BinarySearchTree<K, V> left;
    private BinarySearchTree<K, V> right;

    public BinarySearchTree(
        TreeNode<K, V> root,
        BinarySearchTree<K, V> left,
        BinarySearchTree<K, V> right
    ) {
        super(root, left, right);
        this.root = root;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean has(K key) {
        if (this.isEmpty()) {
            return false;
        } else if (this.root.getKey().equals(key)) {
            return true;
        } else if (this.root.getKey().compareTo(key) > 0) {
            return left.has(key);
        } else {
            return right.has(key);
        }
    }

    @Override
    public V get(K key) {
        if (this.isEmpty()) {
            return null;
        } else if (this.root.getKey().equals(key)) {
            return root.getValue();
        } else if (this.root.getKey().compareTo(key) > 0) {
            return left.get(key);
        } else {
            return right.get(key);
        }
    }

    @Override
    public void set(K key, V value) {
        if (this.isEmpty()) {
            root = new TreeNode<>(key, value);
        } else if (this.root.getKey().equals(key)) {
            root.setValue(value);
        } else if (this.root.getKey().compareTo(key) > 0) {
            left.set(key, value);
        } else {
            right.set(key, value);
        }
    }

    @Override
    public void remove(K key) {
        if (isEmpty()) {
            return;
        } else if (this.root.getKey().compareTo(key) > 0) {
            left.remove(key);
        } else if (this.root.getKey().compareTo(key) < 0) {
            right.remove(key);
        } else {
            if (left.isEmpty()) {
                root = right.root();
                left = (BinarySearchTree<K, V>) right.left();
                right = (BinarySearchTree<K, V>) right.right();
            } else if (right.isEmpty()) {
                root = left.root;
                left = (BinarySearchTree<K, V>) left.left();
                right = (BinarySearchTree<K, V>) left.right();
            } else {
                
            }
        }
    }
}

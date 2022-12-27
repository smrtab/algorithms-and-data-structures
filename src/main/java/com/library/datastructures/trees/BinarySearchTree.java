package com.library.datastructures.trees;

import com.library.datastructures.queues.LinkedQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V>
        implements BinarySearchTreeADT<K, V> {

    private TreeNode<K, V> root;
    private BinarySearchTreeADT<K, V> left;
    private BinarySearchTreeADT<K, V> right;

    public BinarySearchTree() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public BinarySearchTree(
        TreeNode<K, V> root,
        BinarySearchTree<K, V> left,
        BinarySearchTree<K, V> right
    ) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean hasKey(K key) {
        if (this.isEmpty()) {
            return false;
        } else if (this.root.getKey().equals(key)) {
            return true;
        } else if (this.root.getKey().compareTo(key) > 0) {
            return left.hasKey(key);
        } else {
            return right.hasKey(key);
        }
    }

    @Override
    public TreeNode<K, V> root() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null && left == null && right == null;
    }

    @Override
    public boolean isLeaf() {
        return !this.isEmpty() && left.isEmpty() && right.isEmpty();
    }

    @Override
    public BinarySearchTreeADT<K, V> left() {
        return left;
    }

    @Override
    public BinarySearchTreeADT<K, V> right() {
        return right;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return left.size() + right.size() + 1;
        }
    }

    @Override
    public int height() {
        if (isEmpty()) {
            return 0;
        } else {
            return Math.max(left().height(), right().height()) + 1;
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
        set(key, value, 0);
    }

    @Override
    public void set(K key, V value, int level) {
        if (isEmpty()) {
            root = new TreeNode<>(key, value, level);
            left = new BinarySearchTree<>();
            right = new BinarySearchTree<>();
        } else if (root.getKey().equals(key)) {
            root.setValue(value);
        } else if (root.getKey().compareTo(key) > 0) {
            left.set(key, value, ++level);
        } else {
            right.set(key, value, ++level);
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
                left = right.left();
                right = right.right();
            } else if (right.isEmpty()) {
                root = left.root();
                left = left.left();
                right = left.right();
            } else {
                root = right.smallest();
                right.remove(root.getKey());
            }
        }
    }

    @Override
    public boolean isBalanced() {
        if (isEmpty()) {
            return true;
        } else {
            if (!left.isBalanced() || !right.isBalanced()) {
                return false;
            } else {
                int balanceFactor = left.height() - right.height();
                return balanceFactor >= -1 && balanceFactor <= 1;
            }
        }
    }

    public TreeNode<K, V> smallest() {
        BinarySearchTreeADT<K, V> tree = this;
        while (!tree.left().isEmpty()) {
            tree = tree.left();
        }
        return tree.root();
    }

    public void print() {
        int height = height();
        LinkedQueue<BinarySearchTreeADT<K, V>> queue = new LinkedQueue<>();
        queue.enqueue(this);
        int prevLevel = -1;
        while (queue.size() > 0) {
            BinarySearchTreeADT<K, V> tree = queue.dequeue();
            TreeNode<K, V> node = tree.root();

            String indent = " ".repeat(height - node.getLevel());
            if (prevLevel != node.getLevel()) {
                System.out.println();
                prevLevel = node.getLevel();
                indent = " ".repeat((height - node.getLevel()) * 10);
            }

            System.out.print(indent + "(" + node.getKey() + ":" + node.getValue() + ")");

            if (!tree.left().isEmpty()) {
                queue.enqueue(tree.left());
            }

            if (!tree.right().isEmpty()) {
                queue.enqueue(tree.right());
            }
        }
    }
}

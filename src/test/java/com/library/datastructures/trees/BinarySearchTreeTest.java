package com.library.datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private final static BinarySearchTree<Integer, String> EMPTY = new BinarySearchTree<>();
    private BinarySearchTree<Integer, String> tree;

    @BeforeEach
    void setUp() {
        TreeNode<Integer, String> root = new TreeNode<>(4, "e");
        tree = new BinarySearchTree<>(root, new BinarySearchTree<>(), new BinarySearchTree<>());
        tree.set(2, "c");
        tree.set(3, "d");
        tree.set(0, "a");
        tree.set(6, "f");
        tree.set(7, "h");
        tree.set(5, "j");
        tree.print();
    }

    @Test
    public void testSize() {
        assertEquals(7, tree.size());
    }

    @Test
    public void testHeight() {
        assertEquals(3, tree.height());
    }
}
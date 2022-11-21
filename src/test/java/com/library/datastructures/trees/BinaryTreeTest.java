package com.library.datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private final static BinaryTree<String> EMPTY = new BinaryTree<>();
    private BinaryTree<String> tree;

    @BeforeEach
    void setUp() {
        //((3+4)*5)–6
        BinaryTree<String> leaf3 = new BinaryTree<>("3", EMPTY, EMPTY);
        BinaryTree<String> leaf4 = new BinaryTree<>("4", EMPTY, EMPTY);
        BinaryTree<String> leaf5 = new BinaryTree<>("5", EMPTY, EMPTY);
        BinaryTree<String> leaf6 = new BinaryTree<>("6", EMPTY, EMPTY);
        tree = new BinaryTree<>("-",
            new BinaryTree<>("*",
                new BinaryTree<>("+", leaf3, leaf4),
                leaf5
            ),
            leaf6
        );
    }

    @Test
    public void testIsEmptyPositive() {
        assertTrue(EMPTY.isEmpty());
    }

    @Test
    public void testIsEmptyNegative() {
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testHasPositive3Times() {
        assertTrue(tree.has("3"));
        assertTrue(tree.has("4"));
        assertTrue(tree.has("5"));
    }

    @Test
    public void testHasNegative3Times() {
        assertFalse(tree.has("7"));
        assertFalse(tree.has("8"));
        assertFalse(tree.has("9"));
    }

    @Test
    public void testInfix() {
        assertEquals("(((3 + 4) * 5) - 6)", tree.infix());
    }

    @Test
    public void testBFS() {
        //(((3 + 4) * 5) - 6)
        assertEquals("[-, *, 6, +, 5, 3, 4]", tree.breadthFirstSearch().toString());
    }
}
package com.library.datastructures.trees;

import com.library.datastructures.queues.LinkedQueue;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> implements BinaryTreeADT<T> {

    private final T root;
    private final BinaryTreeADT<T> left;
    private final BinaryTreeADT<T> right;

    public BinaryTree() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(
        T root,
        BinaryTreeADT<T> left,
        BinaryTreeADT<T> right
    ) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    @Override
    public T root() {
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
    public boolean has(T item) {
        if (isEmpty()) {
            return false;
        } else if (root.equals(item)) {
            return true;
        } else {
            return left.has(item) || right.has(item);
        }
    }

    @Override
    public BinaryTreeADT<T> left() {
        return left;
    }

    @Override
    public BinaryTreeADT<T> right() {
        return right;
    }

    @Override
    public int height() {
        if (isLeaf()) {
            return 1;
        } else {
            return Math.max(left().height(), right().height()) + 1;
        }
    }

    @Override
    public int size() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return this.left().size() + this.right().size() + 1;
        }
    }

    @Override
    public String infix() {
        if (this.isEmpty()) {
            return "";
        } else if (this.isLeaf()) {
            assert root != null;
            return root.toString();
        } else {
            assert root != null;
            assert left != null;
            assert right != null;
            return String.format("(%s %s %s)", left.infix(), root, right.infix());
        }
    }

    @Override
    public void postfix() {
        if (this.isEmpty()) {
            return;
        } else {
            left.infix();
            right.infix();
            System.out.print(root);
        }
    }

    @Override
    public List<T> breadthFirstSearch() {

        LinkedQueue<BinaryTreeADT<T>> queue = new LinkedQueue<>();
        queue.enqueue(this);

        List<T> output = new ArrayList<>();
        while (queue.size() > 0) {

            BinaryTreeADT<T> current = queue.dequeue();

            assert current.root() != null;
            output.add(current.root());

            assert current.left() != null;
            if (!current.left().isEmpty()) {
                queue.enqueue(current.left());
            }

            assert current.right() != null;
            if (!current.right().isEmpty()) {
                queue.enqueue(current.right());
            }
        }
        return output;
    }
}

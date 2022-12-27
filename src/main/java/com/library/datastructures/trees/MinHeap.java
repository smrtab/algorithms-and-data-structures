package com.library.datastructures.trees;

import com.library.datastructures.queues.LinkedQueue;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<K extends Comparable<K>, V> {

    private List<TreeNode<K, V>> items;

    public MinHeap() {
        items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public void set(K key, V value) {
        TreeNode<K, V> node = new TreeNode<>(key, value);
        items.add(node);
        int index = items.size() - 1;
        int parent = (int) Math.floor((index - 1) / 2d);
        while (index > 0 && items.get(index).getKey()
                .compareTo(items.get(parent).getKey()) < 0) {
            swap(index, parent);
            index = parent;
            parent = (int) Math.floor((index - 1) / 2d);
        }
    }

    public TreeNode<K, V> dequeue() {
        TreeNode<K, V> node = items.get(0);
        swap(0, items.size() - 1);
        items.remove(items.size() - 1);
        bubbleDown(0);
        return node;
    }

    private void bubbleDown(int index) {
        int left = 2 * index - 1;
        if (left >= items.size()) {
            return;
        }
        int right = left + 1;
        int smallest = left;
        if (right < items.size() && items.get(left).getKey()
                .compareTo(items.get(right).getKey()) > 0) {
            smallest = right;
        }
        if (items.get(index).getKey()
                .compareTo(items.get(smallest).getKey()) > 0) {
            swap(index, smallest);
            bubbleDown(smallest);
        }
    }

    public int height() {
        return 0;
    }

    private void swap(int left, int right) {
        TreeNode<K, V> temp = items.get(left);
        items.set(left, items.get(right));
        items.set(right, temp);
    }

    public void print() {
        int height = height();
        LinkedQueue<BinarySearchTreeADT<K, V>> queue = new LinkedQueue<>();
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

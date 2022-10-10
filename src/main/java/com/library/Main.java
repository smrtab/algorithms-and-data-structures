package com.library;

import com.library.datastructures.arrays.DynamicArray;
import com.library.datastructures.hashtables.HashTableSeparateChaining;
import com.library.datastructures.linkedlists.LinkedList;
import com.library.datastructures.queues.LinkedQueue;
import com.library.datastructures.stacks.Stack;

public class Main {

    public static void main(String[] args) {
        testDynamicArrayAppending();
        testHashTableSeparateChaining();
        testLinkedList();
        testStack();
        testLinkedQueue();
    }

    private static void testDynamicArrayAppending() {
        System.out.println("\n======= DynamicArray =======");
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();
        int[] input = new int[24];
        for (int i = 0; i < input.length; i++) {
            integerDynamicArray.add(i);
            System.out.println(integerDynamicArray);
        }
    }

    private static void testHashTableSeparateChaining() {
        System.out.println("\n======= HashTableSeparateChaining =======");
        HashTableSeparateChaining<String, Integer> hashTableSeparateChaining = new HashTableSeparateChaining<>();
        String[] input = new String[] {"a", "b", "c", "d", "aa", "an", "am", "mm", "34", "qwe"};
        for (int i = 0; i < input.length; i++) {
            hashTableSeparateChaining.add(input[i], i);
            System.out.println(hashTableSeparateChaining);
        }
    }

    private static void testLinkedList() {
        System.out.println("\n======= LinkedList =======");
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            linkedList.append(i);
            System.out.println(linkedList);
        }

        System.out.println("Remove at index 0");
        linkedList.remove(0);
        System.out.println(linkedList);

        System.out.println("Remove last element");
        linkedList.remove(linkedList.getSize() - 1);
        System.out.println(linkedList);

        System.out.println("Insert at last index");
        linkedList.insert(linkedList.getSize() - 1, 100);
        System.out.println(linkedList);

        Integer value = linkedList.get(linkedList.getSize() - 2);
        System.out.print("Check value at this index: " + value);
    }

    private static void testStack() {
        System.out.println("\n======= Stack =======");
        Stack<Integer> stack = new Stack<>(5);
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        int poppedValue = stack.pop();
        System.out.println("Popped: " + poppedValue);
        System.out.println(stack);

        poppedValue = stack.pop();
        System.out.println("Popped: " + poppedValue);
        System.out.println(stack);

        poppedValue = stack.pop();
        System.out.println("Popped: " + poppedValue);
        System.out.println(stack);

        int peekedValue = stack.peek();
        System.out.println("Peeked: " + peekedValue);
        System.out.println(stack);
    }

    private static void testLinkedQueue() {
        System.out.println("\n======= LinkedQueue =======");
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            linkedQueue.enqueue(i);
            System.out.println(linkedQueue);
        }

        int dequeuedValue = linkedQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedValue);
        System.out.println(linkedQueue);

        dequeuedValue = linkedQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedValue);
        System.out.println(linkedQueue);

        dequeuedValue = linkedQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedValue);
        System.out.println(linkedQueue);

        int peekedValue = linkedQueue.peek();
        System.out.println("Peeked: " + peekedValue);
        System.out.println(linkedQueue);
    }
}
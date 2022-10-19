package com.library;

import com.library.datastructures.arrays.DynamicArray;
import com.library.datastructures.hashtables.HashTableSeparateChaining;
import com.library.datastructures.linkedlists.DoublyLinkedList;
import com.library.datastructures.linkedlists.SinglyLinkedList;
import com.library.datastructures.priorityqueues.SinglyLinkedPriorityQueue;
import com.library.datastructures.queues.LinkedQueue;
import com.library.datastructures.sets.HashSet;
import com.library.datastructures.sets.SetADT;
import com.library.datastructures.stacks.Stack;

public class Main {

    public static void main(String[] args) {
        testDynamicArrayAppending();
        testHashTableSeparateChaining();
        testSinglyLinkedList();
        testDoublyLinkedList();
        testStack();
        testLinkedQueue();
        testSinglyLinkedPriorityQueue();
        testHashSet();
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

        for (String key : hashTableSeparateChaining) {
            System.out.print(key + " ");
        }
    }

    private static void testSinglyLinkedList() {
        System.out.println("\n======= SinglyLinkedList =======");
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            singlyLinkedList.append(i);
            System.out.println(singlyLinkedList);
        }

        System.out.println("Remove at index 0");
        singlyLinkedList.remove(0);
        System.out.println(singlyLinkedList);

        System.out.println("Remove last element");
        singlyLinkedList.remove(singlyLinkedList.size() - 1);
        System.out.println(singlyLinkedList);

        System.out.println("Insert at last index");
        singlyLinkedList.insert(singlyLinkedList.size() - 1, 100);
        System.out.println(singlyLinkedList);

        Integer value = singlyLinkedList.get(singlyLinkedList.size() - 2);
        System.out.print("Value at index: " + (singlyLinkedList.size() - 2) + " = " + value);

        singlyLinkedList.set(singlyLinkedList.size() - 2, 200);
        System.out.println("Set value 200 at index: " + (singlyLinkedList.size() - 2));
        System.out.println(singlyLinkedList);

        value = singlyLinkedList.get(singlyLinkedList.size() - 2);
        System.out.print("Value at index: " + (singlyLinkedList.size() - 2) + " = " + value);
    }

    private static void testDoublyLinkedList() {
        System.out.println("\n======= DoublyLinkedList =======");
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            doublyLinkedList.append(i);
            System.out.println(doublyLinkedList);
        }

        System.out.println("Remove at index 0");
        doublyLinkedList.remove(0);
        System.out.println(doublyLinkedList);

        System.out.println("Remove last element");
        doublyLinkedList.remove(doublyLinkedList.size() - 1);
        System.out.println(doublyLinkedList);

        System.out.println("Insert at last index");
        doublyLinkedList.insert(doublyLinkedList.size() - 1, 100);
        System.out.println(doublyLinkedList);

        Integer value = doublyLinkedList.get(doublyLinkedList.size() - 2);
        System.out.println("Value at index: " + (doublyLinkedList.size() - 2) + " = " + value);

        doublyLinkedList.set(doublyLinkedList.size() - 2, 200);
        System.out.println("Set value 200 at index: " + (doublyLinkedList.size() - 2));
        System.out.println(doublyLinkedList);

        value = doublyLinkedList.get(doublyLinkedList.size() - 2);
        System.out.println("Value at index: " + (doublyLinkedList.size() - 2) + " = " + value);
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

    private static void testSinglyLinkedPriorityQueue() {
        System.out.println("\n======= SinglyLinkedPriorityQueue =======");
        SinglyLinkedPriorityQueue<Integer, Integer> singlyLinkedPriorityQueue = new SinglyLinkedPriorityQueue<>();
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            singlyLinkedPriorityQueue.enqueue(i, i);
            System.out.println(singlyLinkedPriorityQueue);
        }

        singlyLinkedPriorityQueue.enqueue(10, 4);
        System.out.println("Enqueue priority 4: ");
        System.out.println(singlyLinkedPriorityQueue);

        singlyLinkedPriorityQueue.enqueue(11, 3);
        System.out.println("Enqueue priority 3: ");
        System.out.println(singlyLinkedPriorityQueue);

        int dequeuedValue = singlyLinkedPriorityQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedValue);
        System.out.println(singlyLinkedPriorityQueue);

        dequeuedValue = singlyLinkedPriorityQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedValue);
        System.out.println(singlyLinkedPriorityQueue);

        dequeuedValue = singlyLinkedPriorityQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedValue);
        System.out.println(singlyLinkedPriorityQueue);

        int peekedValue = singlyLinkedPriorityQueue.peek();
        System.out.println("Peeked: " + peekedValue);
        System.out.println(singlyLinkedPriorityQueue);
    }

    private static void testHashSet() {
        System.out.println("\n======= HashSet =======");
        HashSet<Integer> hashSet = new HashSet<>();
        int[] input = new int[5];
        for (int i = 0; i < input.length; i++) {
            hashSet.add(i);
            System.out.println(hashSet);
        }

        System.out.println("Try to add them again: ");
        for (int i = 0; i < input.length; i++) {
            hashSet.add(i);
            System.out.println(hashSet);
        }

        System.out.print("Iterator: ");
        for (int item : hashSet) {
            System.out.print(item + " ");
        }

        System.out.println("\nRemove value 0");
        hashSet.remove(0);
        System.out.print("Iterator: ");
        for (int item : hashSet) {
            System.out.print(item + " ");
        }

        System.out.println("\nRemove value 3");
        hashSet.remove(3);
        System.out.print("Iterator: ");
        for (int item : hashSet) {
            System.out.print(item + " ");
        }

        int[] inputForUnion = new int[] {5, 6, 7};
        HashSet<Integer> hashSetForUnion = new HashSet<>();
        for (int i = 0; i < inputForUnion.length; i++) {
            hashSetForUnion.add(inputForUnion[i]);
        }

        int[] inputForIntersection = new int[] {2, 4, 5};
        HashSet<Integer> hashSetForIntersection = new HashSet<>();
        for (int i = 0; i < inputForIntersection.length; i++) {
            hashSetForIntersection.add(inputForIntersection[i]);
        }

        System.out.println("\nUnion with {5, 6, 7}");
        SetADT<Integer> union = hashSet.union(hashSetForUnion);
        System.out.print("Iterator: ");
        for (int item : union) {
            System.out.print(item + " ");
        }

        System.out.println("\nIntersection with {2, 4, 5}");
        SetADT<Integer> intersection = union.intersection(hashSetForIntersection);
        System.out.print("Iterator: ");
        for (int item : intersection) {
            System.out.print(item + " ");
        }
    }
}
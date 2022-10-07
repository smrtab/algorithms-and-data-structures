package com.library;

import com.library.datastructures.arrays.DynamicArray;
import com.library.datastructures.hashtable.HashTableSeparateChaining;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //testDynamicArrayAppending();
        testHashTableSeparateChaining();
    }

    private static void testDynamicArrayAppending() {
        Scanner scanner = new Scanner(System.in);
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            integerDynamicArray.add(value);
            System.out.println(integerDynamicArray);
        }
    }

    private static void testHashTableSeparateChaining() {
        Scanner scanner = new Scanner(System.in);
        HashTableSeparateChaining<String, Integer> hashTableSeparateChaining = new HashTableSeparateChaining<>();
        while (scanner.hasNext()) {

            Random random = new Random();

            int value = random.nextInt();
            String key = scanner.next();

            hashTableSeparateChaining.add(key, value);

            System.out.println(hashTableSeparateChaining);
        }
    }
}
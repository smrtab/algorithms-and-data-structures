package com.library.datastructures.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    private Sort<Integer> sort;

    private final List<Integer> input = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 5; i >= 0; i--) {
            input.add(i);
        }
        sort = new Sort<>(input);
    }

    @Test
    public void testInsertionSortPositive() {
        List<Integer> sortedList = sort.insertionSort();
        assertEquals("[0, 1, 2, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testInsertionSortNegative() {
        List<Integer> sortedList = sort.insertionSort();
        assertNotEquals("[0, 2, 1, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testBubbleSortPositive() {
        List<Integer> sortedList = sort.bubbleSort();
        assertEquals("[0, 1, 2, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testBubbleSortNegative() {
        List<Integer> sortedList = sort.bubbleSort();
        assertNotEquals("[0, 2, 1, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testSelectionSortPositive() {
        List<Integer> sortedList = sort.selectionSort();
        assertEquals("[0, 1, 2, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testSelectionSortNegative() {
        List<Integer> sortedList = sort.selectionSort();
        assertNotEquals("[0, 2, 1, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testMergeSortPositive() {
        List<Integer> sortedList = sort.mergeSort();
        assertEquals("[0, 1, 2, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testMergeSortNegative() {
        List<Integer> sortedList = sort.mergeSort();
        assertNotEquals("[0, 2, 1, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testQuickSortedPositive() {
        List<Integer> sortedList = sort.quickSorted();
        assertEquals("[0, 1, 2, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testQuickSortedNegative() {
        List<Integer> sortedList = sort.quickSorted();
        assertEquals("[0, 1, 2, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testQuickSortPositive() {
        List<Integer> sortedList = sort.quickSort();
        assertEquals("[0, 1, 2, 3, 4, 5]", sortedList.toString());
    }

    @Test
    public void testQuickSort2Positive() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 8, 3, 7, 1, 0, 9, 5, 5, 2, 6, 4));
        Sort<Integer> sort = new Sort<>(input);
        List<Integer> sortedList = sort.quickSort();
        assertEquals("[0, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9]", sortedList.toString());
    }
}
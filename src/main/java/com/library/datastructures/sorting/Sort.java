package com.library.datastructures.sorting;

import com.library.datastructures.recursion.Sequence;

import java.util.ArrayList;
import java.util.List;

public class Sort<T extends Comparable<T>> {

    private final List<T> items;

    private final Recursion recursion;

    public Sort(List<T> items) {
        this.items = items;
        this.recursion = new Recursion();
    }

    public List<T> insertionSort() {
        for (int i = 0; i < items.size(); i++) {
            int index = i;
            T sortItem = items.get(i);
            while (index > 0 && items.get(index - 1).compareTo(sortItem) > 0) {
                items.set(index, items.get(index - 1));
                index--;
            }
            items.set(index, sortItem);
        }
        return items;
    }

    public List<T> bubbleSort() {
        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(j).compareTo(items.get(i)) < 0) {
                    swap(i, j);
                }
            }
        }
        return items;
    }

    public List<T> selectionSort() {
        for (int i = 0; i < items.size() - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(j).compareTo(items.get(i)) < 0) {
                    smallest = j;
                }
            }
            swap(i, smallest);
        }
        return items;
    }

    /**
     * if n < 2: T(n) = Θ(1)
     * if n ≥ 2: T(n) = 2×Θ(n / 2) + 2×T(n / 2) + 2×Θ(n / 2) = 2×T(n / 2) + Θ(n).
     */
    public List<T> mergeSort() {
        return recursion.mergeSort(items);
    }

    private List<T> merge(List<T> left, List<T> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<T> sorted = new ArrayList<>();
        while (leftIndex < left.size() && rightIndex < right.size()) {
            T leftItem = left.get(leftIndex);
            T rightItem = right.get(rightIndex);
            if (leftItem.compareTo(rightItem) <= 0) {
                sorted.add(leftItem);
                leftIndex++;
            } else {
                sorted.add(rightItem);
                rightIndex++;
            }
        }
        for (int i = leftIndex; i < left.size(); i++) {
            sorted.add(left.get(i));
        }
        for (int i = rightIndex; i < left.size(); i++) {
            sorted.add(right.get(i));
        }
        return sorted;
    }

    public List<T> quickSorted() {
        return recursion.quickSorted(items);
    }

    public List<T> quickSort() {
        recursion.quickSort(0, items.size() - 1);
        return items;
    }

    private void swap(int left, int right) {
        T temp = items.get(left);
        items.set(left, items.get(right));
        items.set(right, temp);
    }

    private class Recursion {

        private List<T> mergeSort(List<T> items) {
            if (items.size() < 2) {
                return items;
            } else {
                int middle = items.size() / 2;
                List<T> leftSorted = mergeSort(items.subList(0, middle));
                List<T> rightSorted = mergeSort(items.subList(middle, items.size()));
                return merge(leftSorted, rightSorted);
            }
        }

        private List<T> quickSorted(List<T> items) {
            if (items.size() < 2) {
                return items;
            } else {
                T pivot = items.get(0);
                List<T> smaller = new ArrayList<>();
                List<T> bigger = new ArrayList<>();
                for (int i = 1; i < items.size(); i++) {
                    T item = items.get(i);
                    if (item.compareTo(pivot) < 0) {
                        smaller.add(item);
                    } else {
                        bigger.add(item);
                    }
                }
                List<T> sorted = quickSorted(smaller);
                sorted.add(pivot);
                sorted.addAll(quickSorted(bigger));
                return sorted;
            }
        }

        private void quickSort(int start, int end) {
            if (start >= end) {
                return;
            }

            int pivotIndex = start;
            int endIndex = end;
            T pivot = items.get(pivotIndex);

            start++;
            while (start < end) {
                while (start < endIndex && items.get(start).compareTo(pivot) < 0) {
                    start++;
                }
                while (end > pivotIndex && items.get(end).compareTo(pivot) >= 0) {
                    end--;
                }

                if (start < end) {
                    swap(start, end);
                }
                //System.out.println("start=" + start + " end=" + end + " " + items);
            }

            swap(pivotIndex, end);
           // System.out.println("pivotIndex=" + pivotIndex + " end=" + end + " " + items);
            quickSort(pivotIndex, end - 1);
            quickSort(end + 1, endIndex);
        }
    }
}
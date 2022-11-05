package com.library.datastructures.divide;

import com.library.datastructures.recursion.Subset;

import java.util.List;

public class BinarySearch {

    private final Recursion recursion;

    public BinarySearch() {
        this.recursion = new Recursion();
    }

    public <T extends Comparable<T>> boolean has(List<T> items, T item) {
        int start = 0;
        int end = items.size();
        boolean found = false;
        while (start < end && !found) {
            int middle = start + (end - start) / 2;
            T middleItem = items.get(middle);
            if (item.compareTo(middleItem) == 0) {
                found = true;
            } else if (item.compareTo(middleItem) > 0) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return found;
    }

    public <T extends Comparable<T>> boolean hasRecursive(List<T> items, T item) {
        return recursion.hasRecursive(items, item, 0, items.size());
    }

    private class Recursion {

        private  <T extends Comparable<T>> boolean hasRecursive(List<T> items, T item, int start, int end) {
            System.out.println("Searching " + item + " in " + items.subList(start, end));
            if (start == end) {
                return false;
            } else {
                int middle = start + (end - start) / 2;
                T middleItem = items.get(middle);
                if (item.compareTo(middleItem) == 0) {
                    return true;
                } else if (item.compareTo(middleItem) > 0) {
                    return hasRecursive(items, item, middle + 1, end);
                } else {
                    return hasRecursive(items, item, start, middle);
                }
            }
        }
    }
}

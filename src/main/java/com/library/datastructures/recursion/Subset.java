package com.library.datastructures.recursion;

import com.library.datastructures.arrays.DynamicArray;
import com.library.datastructures.sets.HashSet;

public class Subset {

    private final Recursion recursion;

    public Subset() {
        this.recursion = new Recursion();
    }

    public <T> DynamicArray<HashSet<T>> getAllSubsets(HashSet<T> subset) {
        if (subset.isEmpty()) {
            DynamicArray<HashSet<T>> emptyList = new DynamicArray<>();
            HashSet<T> emptyHashSet  = new HashSet<>();
            emptyList.add(emptyHashSet);
            return emptyList;
        } else {
            T item = subset.toArray().get(0);
            HashSet<T> rest = (HashSet<T>) subset.difference(new HashSet<>(item));
            DynamicArray<HashSet<T>> subSolution = getAllSubsets(rest);
            DynamicArray<HashSet<T>> newSubsets = new DynamicArray<>();
            for (HashSet<T> solution : subSolution) {
                solution.add(item);
                newSubsets.add(solution);
            }
            for (HashSet<T> newSubset : newSubsets) {
                subSolution.add(newSubset);
            }
            return subSolution;
        }
    }

    private class Recursion {
    }
}

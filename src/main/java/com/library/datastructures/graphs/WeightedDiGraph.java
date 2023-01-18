package com.library.datastructures.graphs;

import com.library.datastructures.common.Triple;
import com.library.datastructures.common.Tuple;
import com.library.datastructures.priorityqueues.SinglyLinkedPriorityQueue;
import com.library.datastructures.trees.MinHeap;
import com.library.datastructures.trees.TreeNode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class WeightedDiGraph<T> extends DiGraph<T> implements WeightedGraphADT<T> {
    @Override
    public void addEdge(T from, T to, int weight) {
        if (!list.containsKey(from) || !list.containsKey(to)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        list.get(from).put(to, weight);
    }

    @Override
    public int weight(T from, T to) {
        return list.get(from).get(to);
    }

    @Override
    public WeightedGraphADT<T> mst(T start) {

        WeightedDiGraph<T> visited = new WeightedDiGraph<>();
        visited.addNode(start);

        MinHeap<Integer, Tuple<T, T>> processed = new MinHeap<>();
        for (T node : outNeighbours(start)) {
            int weight = weight(start, node);
            processed.set(weight, new Tuple<>(start, node));
        }

        while (processed.size() > 0) {
            TreeNode<Integer, Tuple<T, T>> processedItem = processed.dequeue();
            int cost = processedItem.getKey();
            T previous = processedItem.getValue().getKey();
            T current = processedItem.getValue().getValue();
            if (!visited.hasNode(current)) {
                visited.addNode(current);
                visited.addEdge(previous, current, cost);
                for (T node : outNeighbours(current)) {
                    int weight = weight(start, node);
                    processed.set(weight, new Tuple<>(current, node));
                }
            }
        }

        return visited;
    }

    @Override
    public WeightedGraphADT<T> dijkstra(T start) {

        WeightedDiGraph<T> visited = new WeightedDiGraph<>();
        visited.addNode(start);

        MinHeap<Integer, Triple<T, T, Integer>> processed = new MinHeap<>();
        for (T node : outNeighbours(start)) {
            int weight = weight(start, node);
            processed.set(weight, new Triple<>(start, node, weight));
        }

        while (processed.size() > 0) {
            TreeNode<Integer, Triple<T, T, Integer>> processedItem = processed.dequeue();
            int cost = processedItem.getKey();

            T previous = processedItem.getValue().getFirst();
            T current = processedItem.getValue().getSecond();
            Integer weight =processedItem.getValue().getThird();

            if (!visited.hasNode(current)) {
                visited.addNode(current);
                visited.addEdge(previous, current, weight);
                for (T node : outNeighbours(current)) {
                    weight = weight(start, node);
                    processed.set(cost + weight, new Triple<>(current, node, weight));
                }
            }
        }

        return visited;
    }
}

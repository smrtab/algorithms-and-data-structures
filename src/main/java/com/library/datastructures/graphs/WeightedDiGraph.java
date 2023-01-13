package com.library.datastructures.graphs;

public class WeightedDiGraph<T> extends DiGraph<T> implements WeightedGraphADT<T> {
    @Override
    public void addEdge(T from, T to, int weight) {
        if (!list.containsKey(from) || !list.containsKey(to)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        list.get(from).put(to, weight);
    }

    @Override
    public WeightedGraphADT<T> mst() {
        return null;
    }

    @Override
    public WeightedGraphADT<T> dijkstra(T start) {
        return null;
    }
}

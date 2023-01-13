package com.library.datastructures.graphs;

import com.library.datastructures.common.Tuple;

import java.util.HashSet;

public interface WeightedGraphADT<T> extends GraphADT<T> {
    void addEdge(T from, T to, int weight);
    WeightedGraphADT<T> mst();
    WeightedGraphADT<T> dijkstra(T start);
}

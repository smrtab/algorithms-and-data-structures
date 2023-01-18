package com.library.datastructures.graphs;

import com.library.datastructures.common.Tuple;

import java.util.HashSet;

public interface WeightedGraphADT<T> extends GraphADT<T> {
    void addEdge(T from, T to, int weight);
    int weight(T from, T to);
    WeightedGraphADT<T> mst(T start);
    WeightedGraphADT<T> dijkstra(T start);
}

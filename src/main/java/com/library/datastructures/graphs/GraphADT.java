package com.library.datastructures.graphs;

import com.library.datastructures.common.Tuple;

import java.util.HashSet;

public interface GraphADT<T> {

    boolean hasNode(T value);
    void addNode(T value);
    void removeNode(T value);

    boolean hasEdge(T from, T to);
    void addEdge(T from, T to);
    void removeEdge(T from, T to);

    HashSet<T> nodes();
    HashSet<Tuple<T, T>> edges();

    HashSet<T> outNeighbours(T value);
    HashSet<T> inNeighbours(T value);
    HashSet<T> neighbours(T value);

    int outDegree(T value);
    int inDegree(T value);
    int degree(T value);

    GraphADT<T> bsf(T start);
    GraphADT<T> dsf(T start);
}

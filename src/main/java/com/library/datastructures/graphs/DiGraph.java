package com.library.datastructures.graphs;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class DiGraph<T> implements GraphADT<T> {

    private final HashMap<GraphNode<T>, HashSet<GraphNode<T>>> list;
    private final WrappedNodes wrapper;

    public DiGraph() {
        list = new HashMap<>();
        wrapper = new WrappedNodes();
    }

    @Override
    public boolean hasNode(T value) {
        return wrapper.hasNode(value);
    }

    @Override
    public void addNode(T value) {
        wrapper.addNode(value);
    }

    @Override
    public void removeNode(T value) {
        wrapper.removeNode(value);
    }

    @Override
    public boolean hasEdge(T from, T to) {
        GraphNode<T> fromNode = new GraphNode<>(from);
        GraphNode<T> toNode = new GraphNode<>(to);
        return list.containsKey(fromNode)
                && list.get(fromNode).contains(toNode);
    }

    @Override
    public void addEdge(T from, T to) {
        GraphNode<T> fromNode = new GraphNode<>(from);
        GraphNode<T> toNode = new GraphNode<>(to);
        if (!list.containsKey(fromNode) || !list.containsKey(toNode)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        list.get(fromNode).add(toNode);
    }

    @Override
    public void removeEdge(T from, T to) {
        GraphNode<T> fromNode = new GraphNode<>(from);
        GraphNode<T> toNode = new GraphNode<>(to);
        if (!list.containsKey(fromNode) || !list.containsKey(toNode)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        list.get(fromNode).remove(toNode);
    }

    @Override
    public HashSet<T> nodes() {
        HashSet<T> nodes = new HashSet<>();
        for (GraphNode<T> node: list.keySet()) {
            nodes.add(node.getValue());
        }
        return nodes;
    }

    @Override
    public HashSet<Pair<T, T>> edges() {
        HashSet<Pair<T, T>> edges = new HashSet<>();
        for (GraphNode<T> from: list.keySet()) {
            for (GraphNode<T> to: list.get(from)) {
                edges.add(new Pair<>(from.getValue(), to.getValue()));
            }
        }
        return edges;
    }

    @Override
    public HashSet<T> outNeighbours(T value) {
        GraphNode<T> fromNode = new GraphNode<>(value);
        if (!list.containsKey(fromNode)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        HashSet<T> outNeighbours = new HashSet<>();
        for (GraphNode<T> to: list.get(fromNode)) {
            outNeighbours.add(to.getValue());
        }
        return outNeighbours;
    }

    @Override
    public HashSet<T> inNeighbours(T value) {
        GraphNode<T> toNode = new GraphNode<>(value);
        if (!list.containsKey(toNode)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        HashSet<T> inNeighbours = new HashSet<>();
        for (GraphNode<T> fromNode: list.keySet()) {
            if (hasEdge(fromNode.getValue(), toNode.getValue())) {
                inNeighbours.add(fromNode.getValue());
            }
        }
        return inNeighbours;
    }

    @Override
    public HashSet<T> neighbours(T value) {
        HashSet<T> neighbours = outNeighbours(value);
        neighbours.addAll(inNeighbours(value));
        return neighbours;
    }

    @Override
    public int outDegree(T value) {
        return wrapper.getEdges(value).size();
    }

    @Override
    public int inDegree(T value) {
        return inNeighbours(value).size();
    }

    @Override
    public int degree(T value) {
        return outDegree(value) + inDegree(value);
    }

    @Override
    public String toString() {
        String output = "DiGraph\n";
        for (GraphNode<T> from : list.keySet()) {
            output += from.getValue().toString() + ": [ ";
            for (GraphNode<T> to: list.get(from)) {
                output += to.getValue().toString() + " ";
            }
            output += "]\n";
        }
        return output;
    }

    private class WrappedNodes {

        public HashSet<GraphNode<T>> getEdges(T value) {
            return list.get(new GraphNode<>(value));
        }

        public boolean hasNode(T value) {
            return list.containsKey(new GraphNode<>(value));
        }

        public void addNode(T value) {
            list.put(new GraphNode<>(value), new HashSet<>());
        }

        public void removeNode(T value) {
            list.remove(new GraphNode<>(value));
        }
    }
}

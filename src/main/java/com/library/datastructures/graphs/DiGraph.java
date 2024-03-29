package com.library.datastructures.graphs;

import com.library.datastructures.common.Tuple;
import com.library.datastructures.queues.LinkedQueue;
import com.library.datastructures.stacks.LinkedStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DiGraph<T> implements GraphADT<T> {

    protected final HashMap<T, HashMap<T, Integer>> list;

    public DiGraph() {
        list = new HashMap<>();
    }

    @Override
    public boolean hasNode(T node) {
        return list.containsKey(node);
    }

    @Override
    public void addNode(T value) {
        list.put(value, new HashMap<>());
    }

    @Override
    public void removeNode(T node) {
        list.remove(node);
    }

    @Override
    public boolean hasEdge(T from, T to) {
        return list.containsKey(from) && list.get(from).containsKey(to);
    }

    @Override
    public void addEdge(T from, T to) {
        if (!list.containsKey(from) || !list.containsKey(to)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        list.get(from).put(to, null);
    }

    @Override
    public void removeEdge(T from, T to) {
        if (!list.containsKey(from) || !list.containsKey(to)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        list.get(from).remove(to);
    }

    @Override
    public HashSet<T> nodes() {
        return new HashSet<>(list.keySet());
    }

    @Override
    public HashSet<Tuple<T, T>> edges() {
        HashSet<Tuple<T, T>> edges = new HashSet<>();
        for (T from: list.keySet()) {
            for (T to: list.get(from).keySet()) {
                edges.add(new Tuple<>(from, to));
            }
        }
        return edges;
    }

    @Override
    public HashSet<T> outNeighbours(T fromNode) {
        if (!list.containsKey(fromNode)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        return new HashSet<>(list.get(fromNode).keySet());
    }

    @Override
    public HashSet<T> inNeighbours(T toNode) {
        if (!list.containsKey(toNode)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        HashSet<T> inNeighbours = new HashSet<>();
        for (T fromNode: list.keySet()) {
            if (hasEdge(fromNode, toNode)) {
                inNeighbours.add(fromNode);
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
        return outNeighbours(value).size();
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
    public DiGraph<T> bsf(T value) {

        if (!hasNode(value)) {
            throw new IllegalArgumentException("Invalid node value");
        }

        DiGraph<T> visited = new DiGraph<>();
        LinkedQueue<Tuple<T, T>> unprocessed = new LinkedQueue<>();
        visited.addNode(value);

        for (T outNeighbour: outNeighbours(value)) {
            unprocessed.enqueue(new Tuple<>(value, outNeighbour));
        }

        while (unprocessed.size() > 0) {
            Tuple<T, T> edge = unprocessed.dequeue();
            T previous = edge.getKey();
            T current = edge.getValue();
            if (!visited.hasNode(current)) {
                visited.addNode(current);
                visited.addEdge(previous, current);
                for (T outNeighbour: outNeighbours(current)) {
                    unprocessed.enqueue(new Tuple<>(current, outNeighbour));
                }
            }
        }

        return visited;
    }

    @Override
    public DiGraph<T> dsf(T value) {

        if (!hasNode(value)) {
            throw new IllegalArgumentException("Invalid node value");
        }

        DiGraph<T> visited = new DiGraph<>();
        LinkedStack<Tuple<T, T>> unprocessed = new LinkedStack<>();
        visited.addNode(value);

        for (T outNeighbour: outNeighbours(value)) {
            unprocessed.push(new Tuple<>(value, outNeighbour));
        }

        while (unprocessed.size() > 0) {
            Tuple<T, T> edge = unprocessed.pop();
            T previous = edge.getKey();
            T current = edge.getValue();
            if (!visited.hasNode(current)) {
                visited.addNode(current);
                visited.addEdge(previous, current);
                for (T outNeighbour: outNeighbours(current)) {
                    unprocessed.push(new Tuple<>(current, outNeighbour));
                }
            }
        }

        return visited;
    }

    @Override
    public String toString() {
        String output = "DiGraph\n";
        for (T from : list.keySet()) {
            output += from.toString() + ": [ ";
            for (T to: list.get(from).keySet()) {
                output += to.toString() + " ";
            }
            output += "]\n";
        }
        return output;
    }
}

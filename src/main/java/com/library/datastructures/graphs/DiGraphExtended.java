package com.library.datastructures.graphs;

import com.library.datastructures.common.Tuple;
import com.library.datastructures.queues.LinkedQueue;
import com.library.datastructures.stacks.LinkedStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DiGraphExtended<T> implements GraphADT<T> {

    private final HashMap<GraphNode<T>, HashMap<GraphNode<T>, Integer>> list;
    private final WrappedNodes wrapper;

    public DiGraphExtended() {
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
                && list.get(fromNode).containsKey(toNode);
    }

    @Override
    public void addEdge(T from, T to) {
        GraphNode<T> fromNode = new GraphNode<>(from);
        GraphNode<T> toNode = new GraphNode<>(to);
        if (!list.containsKey(fromNode) || !list.containsKey(toNode)) {
            throw new IllegalArgumentException("Nodes must exist.");
        }
        list.get(fromNode).put(toNode, null);
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
    public HashSet<Tuple<T, T>> edges() {
        HashSet<Tuple<T, T>> edges = new HashSet<>();
        for (GraphNode<T> from: list.keySet()) {
            for (GraphNode<T> to: list.get(from).keySet()) {
                edges.add(new Tuple<>(from.getValue(), to.getValue()));
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
        for (GraphNode<T> to: list.get(fromNode).keySet()) {
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
    public DiGraphExtended<T> bsf(T value) {

        if (!wrapper.hasNode(value)) {
            throw new IllegalArgumentException("Invalid node value");
        }

        DiGraphExtended<T> visited = new DiGraphExtended<>();
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
    public DiGraphExtended<T> dsf(T value) {

        if (!wrapper.hasNode(value)) {
            throw new IllegalArgumentException("Invalid node value");
        }

        DiGraphExtended<T> visited = new DiGraphExtended<>();
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
        for (GraphNode<T> from : list.keySet()) {
            output += from.getValue().toString() + ": [ ";
            for (GraphNode<T> to: list.get(from).keySet()) {
                output += to.getValue().toString() + " ";
            }
            output += "]\n";
        }
        return output;
    }

    private class WrappedNodes {

        public Set<GraphNode<T>> getEdges(T value) {
            return list.get(new GraphNode<>(value)).keySet();
        }

        public boolean hasNode(T value) {
            return list.containsKey(new GraphNode<>(value));
        }

        public void addNode(T value) {
            list.put(new GraphNode<>(value), new HashMap<>());
        }

        public void removeNode(T value) {
            list.remove(new GraphNode<>(value));
        }
    }
}

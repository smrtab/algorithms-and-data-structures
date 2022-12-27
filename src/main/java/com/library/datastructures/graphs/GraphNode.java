package com.library.datastructures.graphs;

import java.util.Objects;

public class GraphNode<T> {

    private T value;

    public GraphNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode<?> graphNode = (GraphNode<?>) o;
        return value.equals(graphNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

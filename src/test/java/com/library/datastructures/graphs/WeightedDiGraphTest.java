package com.library.datastructures.graphs;

import com.library.datastructures.common.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class WeightedDiGraphTest {

    private WeightedDiGraph<String> graph;

    @BeforeEach
    void setUp() {
        graph = new WeightedDiGraph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "C", 4);
        graph.addEdge("D", "C", 5);
        graph.addEdge("B", "D", 2);

        System.out.println(graph);
    }

    @Test
    public void testMstA() {
        WeightedGraphADT<String> mst = graph.mst("A");
        System.out.println(mst.toString());
        assertTrue(mst.hasEdge("A", "B"));
        assertTrue(mst.hasEdge("A", "D"));
        assertTrue(mst.hasEdge("B", "C"));
        assertFalse(mst.hasEdge("B", "D"));
    }
}
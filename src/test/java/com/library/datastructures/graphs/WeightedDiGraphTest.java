package com.library.datastructures.graphs;

import com.library.datastructures.common.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class WeightedDiGraphTest {

    private WeightedDiGraph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new WeightedDiGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);

        System.out.println(graph);
    }

    @Test
    public void testAddNode() {
        graph = new WeightedDiGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        assertTrue(graph.hasNode(1));
        assertTrue(graph.hasNode(2));
        assertFalse(graph.hasNode(3));
    }

    @Test
    public void testAddEdges() {
        graph = new WeightedDiGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 1);
        assertTrue(graph.hasEdge(1, 2));
        assertTrue(graph.hasEdge(3, 1));
        assertFalse(graph.hasEdge(1, 3));
    }

    @Test
    public void testNodes() {
        HashSet<Integer> nodes = graph.nodes();
        assertEquals(5, nodes.size());
    }

    @Test
    public void testEdges() {
        HashSet<Tuple<Integer, Integer>> edges = graph.edges();
        assertEquals(5, edges.size());
    }

    @Test
    public void testOutNeighbours() {
        HashSet<Integer> outNeighbours = graph.outNeighbours(2);
        assertEquals(2, outNeighbours.size());
        assertTrue(outNeighbours.contains(3));
        assertTrue(outNeighbours.contains(4));
        assertFalse(outNeighbours.contains(1));
    }

    @Test
    public void testBsf() {
        DiGraph<Integer> bsfGraph = graph.bsf(2);
        assertEquals(0, bsfGraph.outDegree(1));
        assertTrue(bsfGraph.hasEdge(2, 3));
    }

    @Test
    public void testDsf() {
        DiGraph<Integer> bsfGraph = graph.dsf(2);
        assertEquals(0, bsfGraph.outDegree(1));
        assertTrue(bsfGraph.hasEdge(2, 3));
    }
}
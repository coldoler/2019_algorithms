package com.algorithms.graph.undirected;

public class TestGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');

        graph.addEdge('a', 'b');
        graph.addEdge('b', 'c');
        graph.addEdge('a', 'd');
        graph.addEdge('d', 'e');

        graph.dfs();

    }
}

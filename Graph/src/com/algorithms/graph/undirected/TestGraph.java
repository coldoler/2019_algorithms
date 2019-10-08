package com.algorithms.graph.undirected;

public class TestGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');

        /*
           a --- b
           | ∖ /  ∖
           |  /∖   c
           | /  ∖ /
           d-----e
         */

        graph.addEdge('a', 'b');
        graph.addEdge('b', 'c');
        graph.addEdge('c', 'e');
        graph.addEdge('e', 'd');
        graph.addEdge('d', 'a');
        graph.addEdge('d', 'b');
        graph.addEdge('a', 'e');

        System.out.println("==============DFS==============");
        graph.dfs();
        System.out.println();

        System.out.println("============Minimum Spinning Tree============");
        graph.minimumSpinningTree();
        System.out.println();

        System.out.println("============BFS============");
        graph.bfs();
        System.out.println();
    }

}

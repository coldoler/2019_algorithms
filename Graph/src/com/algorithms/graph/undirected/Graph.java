package com.algorithms.graph.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    private int vertexCount;
    private List<Vertex> vertices;
    private boolean[][] edges;
    private Stack stack;
    private Queue<Vertex> queue;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        vertices = new ArrayList<>();
        edges = new boolean[vertexCount][vertexCount];
        stack = new Stack(vertexCount);
        queue = new LinkedList<>();
    }

    // 面向用户的方法，用户提供label，就可以添加vertex
    public void addVertex(char label) {
        Vertex vertex = new Vertex(label, false);
        vertices.add(vertex);
    }

    // 面向用户的方法，在label_1 和 label_2 表示的两个vertices建edge
    public void addEdge(char label_1, char label_2) {
        int vertex_1_index = getVertexIndex(label_1);
        int vertex_2_index = getVertexIndex(label_2);

        if (vertex_1_index != -1 && vertex_2_index != -1) {
            edges[vertex_1_index][vertex_2_index] = true;
            edges[vertex_2_index][vertex_1_index] = true;
        }
    }

    public void dfs() {
        Vertex vertex = vertices.get(0);
        vertex.setVisited(true);
        displayVertex(vertex);
        stack.push(vertex);

        while(!stack.isEmpty()) {
            // 使用peek的原因是，深度遍历，只选择vertex相连的其中一个vertex
            // 分支进行深度遍历，如果直接pop的话，就会丢失其他与vertex相连的vertices
            Vertex peekVertex = stack.peek();
            Vertex neighbor = getOneUnvisitedNeighbor(peekVertex);
            if (neighbor == null) {
                stack.pop();
            } else {
                neighbor.setVisited(true);
                displayVertex(neighbor);
                stack.push(neighbor);
            }
        }

        // Reset visited flag
        for (Vertex v : vertices) {
            v.setVisited(false);
        }
    }

    // 在图中找到最少edges来连接所有的vertex，在深度遍历的时候
    // 其实就已经完成了这个功能了
    public void minimumSpinningTree() {
        Vertex vertex = vertices.get(0);
        vertex.setVisited(true);
        stack.push(vertex);

        while(!stack.isEmpty()) {
            Vertex peekVertex = stack.peek();
            Vertex neighbor = getOneUnvisitedNeighbor(peekVertex);
            if (neighbor == null) {
                stack.pop();
            } else {
                // Stack中peek那个vertex和neighbor就连接成一条边
                displayVertex(peekVertex);
                displayVertex(neighbor);
                System.out.print(" ");
                neighbor.setVisited(true);
                stack.push(neighbor);
            }
        }

        // Reset visited flag
        for (Vertex v : vertices) {
            v.setVisited(false);
        }
    }

    public void bfs() {
        Vertex vertex = vertices.get(0);
        vertex.setVisited(true);
        displayVertex(vertex);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            // 不同于DFS，BFS是要把和vertex相连的所有neighbor都找到
            // 然后压入queue里，所以这里可以直接remove，而不用peek
            Vertex first = queue.remove();
            Vertex neighbor = null;
            while ((neighbor = getOneUnvisitedNeighbor(first)) != null) {
                queue.add(neighbor);
                displayVertex(neighbor);
                neighbor.setVisited(true);
            }
        }

        // Reset visited flag
        for (Vertex v : vertices) {
            v.setVisited(false);
        }
    }

    private Vertex getOneUnvisitedNeighbor(Vertex vertex) {
        int vertexIndex = getVertexIndex(vertex.getLabel());

        boolean[] neighbors = edges[vertexIndex];

        for (int i = 0; i < neighbors.length; i++) {
            // Connected - is neighbor, and not visited
            if (neighbors[i] == true && !vertices.get(i).isVisited()) {
                return vertices.get(i);
            }
        }
        return null;
    }


    private int getVertexIndex(char label) {
        for (int i = 0; i < vertices.size(); i++) {
            if (label == vertices.get(i).getLabel()) {
                return i;
            }
        }
        return -1;
    }

    private void displayVertex(Vertex vertex) {
        System.out.print(vertex.getLabel());
    }

}

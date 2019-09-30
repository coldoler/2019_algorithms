package com.algorithms.graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int vertexCount = 0;
    private List<Vertex> vertices;
    private boolean[][] adjMatrix;
    private Stack stack;


    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new boolean[vertexCount][vertexCount];
        vertices = new ArrayList<> ();
        stack = new Stack(vertexCount);
    }

    public void addVertex(char label) {
        Vertex v = new Vertex(label, false);
        vertices.add(v);
    }

    public void addEdge(char label1, char label2) {
        int vertex_1_index = getVertexIndex(label1);
        int vertex_2_index = getVertexIndex(label2);

        if (vertex_1_index != -1 && vertex_2_index != -1) {
            adjMatrix[vertex_1_index][vertex_2_index] = true;
            adjMatrix[vertex_2_index][vertex_1_index] = true;
        } else {
            System.err.println("Cannot find this labeled vertex");
        }
    }

    private Vertex getOneAdjUnvisitedVertex(Vertex vertex) {
        int vertexIndex = getVertexIndex(vertex.getLabel());
        boolean[] adjVertices = adjMatrix[vertexIndex];
        Vertex adjUnvisitedVertex = null;

        for (int i = 0; i < adjVertices.length; i++) {
            // 如果i是代表链接到该vertex的另一个vertex的index
            if (adjVertices[i] == true && vertices.get(i).isVisited() == false) {
                adjUnvisitedVertex = vertices.get(i);
            }
        }
        return adjUnvisitedVertex;
    }


    public void dfs() {
        Vertex firstVertex = vertices.get(0);
        displayVertex(firstVertex);
        firstVertex.setVisited(true);
        stack.push(firstVertex);

        while(!stack.isEmpty()) {
            Vertex adjVertex = this.getOneAdjUnvisitedVertex(stack.peek());
            if (adjVertex == null) {
                stack.pop();
            } else {
                displayVertex(adjVertex);
                adjVertex.setVisited(true);
                stack.push(adjVertex);
            }
        }

        // Reset visited flag
        for (Vertex v : vertices) {
            v.setVisited(false);
        }
    }

    private void displayVertex(Vertex vertex) {
        System.out.print(vertex.getLabel());
    }

    private int getVertexIndex(char label) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getLabel() == label) {
                return i;
            }
        }
        return -1;
    }

}

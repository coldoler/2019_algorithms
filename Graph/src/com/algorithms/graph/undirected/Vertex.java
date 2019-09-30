package com.algorithms.graph.undirected;

public class Vertex {

    private char label;
    private boolean visited;

    public Vertex(char label, boolean visited) {
        this.label = label;
        this.visited = visited;
    }

    public char getLabel() {
        return this.label;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

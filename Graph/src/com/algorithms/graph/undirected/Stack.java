package com.algorithms.graph.undirected;

public class Stack {

    private int maxCapacity;
    private Vertex[] container;
    private int topIndex;

    public Stack(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.container = new Vertex[maxCapacity];
        this.topIndex = -1;
    }

    public boolean isFull() {
        return this.topIndex == this.maxCapacity - 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void push(Vertex vertex) {
        if (this.isFull()) {
            System.err.println("Stack is full, cannot push more.");
            System.exit(1);
        }

        container[++topIndex] = vertex;
    }

    public Vertex pop() {
        if (this.isEmpty()) {
            System.err.println("Stack is empty, nothing to pop.");
            System.exit(1);
        }

        return container[topIndex--];
    }

    public Vertex peek() {
        if (this.isEmpty()) {
            System.err.println("Stack is empty, nothing to peek.");
            System.exit(1);
        }

        return container[topIndex];
    }

}

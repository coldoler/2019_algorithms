package com.algorithms.graph.undirected;

public class Stack {

    private int maxCapacity = 0;
    private int currentCapacity = 0;
    private Vertex[] container;
    private int topIndex = -1;

    public Stack(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        container = new Vertex[maxCapacity];
        currentCapacity = 0;
    }

    public void push(Vertex vertex) {
        if (isFull()) {
            System.err.println("Stack is full");
            System.exit(0);
        }

        container[++topIndex] = vertex;
    }

    public Vertex pop() {
        if (isEmpty()) {
            System.err.println("Stack is empty, nothing to pop.");
            System.exit(0);
        }

        return container[topIndex--];
    }

    public Vertex peek() {
        if (isEmpty()) {
            System.err.println("Stack is empty, nothing to peek.");
            System.exit(0);
        }

        return container[topIndex];
    }

    public boolean isFull() {
        return this.maxCapacity == this.currentCapacity;
    }

    public boolean isEmpty() {
        return this.topIndex == -1;
    }

}

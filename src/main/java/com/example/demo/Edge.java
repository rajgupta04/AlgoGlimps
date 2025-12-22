// File Location: src/main/java/com/example/demo/Edge.java
package com.example.demo;

public class Edge {
    private String node;
    private int weight;

    // Getters and Setters are essential for Spring to convert JSON correctly
    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
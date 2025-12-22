// File Location: src/main/java/com/example/demo/GraphData.java
package com.example.demo;

import java.util.List;
import java.util.Map;

public class GraphData {
    // This structure must match the JavaScript 'graph' object
    private Map<String, List<Edge>> graph;
    private String startNode;
    private String targetNode; // Add this for algorithms like Dijkstra

    // Getters and Setters
    public Map<String, List<Edge>> getGraph() {
        return graph;
    }

    public void setGraph(Map<String, List<Edge>> graph) {
        this.graph = graph;
    }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public String getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(String targetNode) {
        this.targetNode = targetNode;
    }
}
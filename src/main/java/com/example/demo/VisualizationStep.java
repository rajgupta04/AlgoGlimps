// File Location: src/main/java/com/example/demo/VisualizationStep.java
package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class VisualizationStep {
    public String currentNode;
    public Set<String> visitedNodes;
    public List<String> queueOrStack;
    public Map<String, Integer> distances; // For Dijkstra
    public List<String> path;
    public Set<String> mstEdges; // For Prim's MST
    public int[][] distanceMatrix; // For Floyd-Warshall
    public int highlightI;
    public int highlightJ;
    public String message;

    public VisualizationStep() {}
}
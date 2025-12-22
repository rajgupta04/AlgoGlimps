package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AlgorithmService {

    public List<VisualizationStep> runBfs(GraphData request) {
        Map<String, List<Edge>> graph = request.getGraph();
        String startNode = request.getStartNode();
        List<VisualizationStep> steps = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();

        if (graph.get(startNode) == null) return steps;

        queue.add(startNode);
        visited.add(startNode);
        steps.add(createStep(null, visited, new ArrayList<>(queue), null, null, null));

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            steps.add(createStep(currentNode, visited, new ArrayList<>(queue), null, null, null));
            if (graph.get(currentNode) == null) continue;
            for (Edge edge : graph.get(currentNode)) {
                if (!visited.contains(edge.getNode())) {
                    visited.add(edge.getNode());
                    queue.add(edge.getNode());
                    steps.add(createStep(currentNode, visited, new ArrayList<>(queue), null, null, null));
                }
            }
        }
        steps.add(createStep(null, visited, new ArrayList<>(), null, null, null)); // Final state
        return steps;
    }

    public List<VisualizationStep> runDfs(GraphData request) {
        Map<String, List<Edge>> graph = request.getGraph();
        String startNode = request.getStartNode();
        List<VisualizationStep> steps = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Set<String> visited = new LinkedHashSet<>();

        stack.push(startNode);
        while(!stack.isEmpty()){
            String currentNode = stack.pop();
            if(visited.contains(currentNode)) continue;
            visited.add(currentNode);
            steps.add(createStep(currentNode, visited, new ArrayList<>(stack), null, null, null));
            if (graph.get(currentNode) == null) continue;
            List<Edge> neighbors = new ArrayList<>(graph.get(currentNode));
            Collections.reverse(neighbors);
            for(Edge edge : neighbors) if(!visited.contains(edge.getNode())) stack.push(edge.getNode());
        }
        steps.add(createStep(null, visited, new ArrayList<>(), null, null, null));
        return steps;
    }

    public List<VisualizationStep> runDijkstra(GraphData request) {
        Map<String, List<Edge>> graph = request.getGraph();
        String startNode = request.getStartNode();
        String endNode = request.getTargetNode();
        List<VisualizationStep> steps = new ArrayList<>();
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Set<String> visited = new HashSet<>();

        for (String node : graph.keySet()) distances.put(node, Integer.MAX_VALUE);
        distances.put(startNode, 0);
        pq.add(new AbstractMap.SimpleEntry<>(startNode, 0));

        while (!pq.isEmpty()) {
            String currentNode = pq.poll().getKey();
            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);
            steps.add(createStep(currentNode, visited, null, distances, null, null));
            if (currentNode.equals(endNode)) break;
            if (graph.get(currentNode) == null) continue;
            for (Edge edge : graph.get(currentNode)) {
                if (!visited.contains(edge.getNode())) {
                    int newDist = distances.get(currentNode) + edge.getWeight();
                    if (newDist < distances.get(edge.getNode())) {
                        distances.put(edge.getNode(), newDist);
                        previousNodes.put(edge.getNode(), currentNode);
                        pq.add(new AbstractMap.SimpleEntry<>(edge.getNode(), newDist));
                    }
                }
            }
        }
        List<String> path = new ArrayList<>();
        String at = endNode;
        while(at != null){ path.add(at); at = previousNodes.get(at); }
        Collections.reverse(path);
        steps.add(createStep(null, visited, null, distances, path, null));
        return steps;
    }

    public List<VisualizationStep> runMst(GraphData request) {
        Map<String, List<Edge>> graph = request.getGraph();
        String startNode = request.getStartNode();
        List<VisualizationStep> steps = new ArrayList<>();
        Set<String> mstEdges = new HashSet<>();
        Map<String, Integer> minCost = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Set<String> visited = new HashSet<>();

        for (String node : graph.keySet()) minCost.put(node, Integer.MAX_VALUE);
        minCost.put(startNode, 0);
        pq.add(new AbstractMap.SimpleEntry<>(startNode, 0));

        while (!pq.isEmpty() && visited.size() < graph.size()) {
            String currentNode = pq.poll().getKey();
            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);
            if (parent.get(currentNode) != null) {
                mstEdges.add(parent.get(currentNode) + "-" + currentNode);
                mstEdges.add(currentNode + "-" + parent.get(currentNode));
            }
            steps.add(createStep(currentNode, visited, null, null, null, mstEdges));
            if (graph.get(currentNode) == null) continue;
            for (Edge edge : graph.get(currentNode)) {
                if (!visited.contains(edge.getNode()) && edge.getWeight() < minCost.get(edge.getNode())) {
                    minCost.put(edge.getNode(), edge.getWeight());
                    parent.put(edge.getNode(), currentNode);
                    pq.add(new AbstractMap.SimpleEntry<>(edge.getNode(), edge.getWeight()));
                }
            }
        }
        steps.add(createStep(null, visited, null, null, null, mstEdges));
        return steps;
    }

    public List<VisualizationStep> runFloydWarshall(GraphData request) {
        Map<String, List<Edge>> graph = request.getGraph();
        List<VisualizationStep> steps = new ArrayList<>();
        List<String> nodes = new ArrayList<>(graph.keySet());
        Collections.sort(nodes);
        int n = nodes.size();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) dist[i][j] = (i == j) ? 0 : 1_000_000;
        for (int i = 0; i < n; i++) {
            String nodeName = nodes.get(i);
            if(graph.get(nodeName) == null) continue;
            for (Edge edge : graph.get(nodeName)) {
                int j = nodes.indexOf(edge.getNode());
                if (j != -1) dist[i][j] = edge.getWeight();
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
                if (dist[i][k] != 1_000_000 && dist[k][j] != 1_000_000 && dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
            VisualizationStep step = new VisualizationStep();
            step.currentNode = nodes.get(k);
            step.distanceMatrix = cloneMatrix(dist);
            step.highlightI = k;
            steps.add(step);
        }
        return steps;
    }
    
    private VisualizationStep createStep(String current, Set<String> visited, List<String> queueOrStack, Map<String, Integer> distances, List<String> path, Set<String> mstEdges) {
        VisualizationStep step = new VisualizationStep();
        step.currentNode = current;
        if (visited != null) step.visitedNodes = new HashSet<>(visited);
        if (queueOrStack != null) step.queueOrStack = new ArrayList<>(queueOrStack);
        if (distances != null) step.distances = new HashMap<>(distances);
        if (path != null) step.path = new ArrayList<>(path);
        if (mstEdges != null) step.mstEdges = new HashSet<>(mstEdges);
        return step;
    }
    
    private int[][] cloneMatrix(int[][] src) { return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new); }
}
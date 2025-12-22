package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/algorithms")
@CrossOrigin(origins = "*")
public class AlgorithmController {

    @Autowired
    private AlgorithmService algorithmService;

    @PostMapping("/bfs")
    public List<VisualizationStep> executeBfs(@RequestBody GraphData request) {
        return algorithmService.runBfs(request);
    }

    @PostMapping("/dfs")
    public List<VisualizationStep> executeDfs(@RequestBody GraphData request) {
        return algorithmService.runDfs(request);
    }
    
    @PostMapping("/dijkstra")
    public List<VisualizationStep> executeDijkstra(@RequestBody GraphData request) {
        return algorithmService.runDijkstra(request);
    }

    @PostMapping("/mst")
    public List<VisualizationStep> executeMst(@RequestBody GraphData request) {
        return algorithmService.runMst(request);
    }

    @PostMapping("/floyd-warshall")
    public List<VisualizationStep> executeFloydWarshall(@RequestBody GraphData request) {
        return algorithmService.runFloydWarshall(request);
    }
}
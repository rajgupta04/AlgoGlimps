package com.example.demo.llm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiApiResponse {
    private List<GeminiCandidate> candidates;

    public GeminiApiResponse() {
    }

    public List<GeminiCandidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<GeminiCandidate> candidates) {
        this.candidates = candidates;
    }
}

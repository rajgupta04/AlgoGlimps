package com.example.demo.llm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiRequest {
    private List<GeminiContent> contents;

    public GeminiRequest() {
    }

    public GeminiRequest(List<GeminiContent> contents) {
        this.contents = contents;
    }

    public List<GeminiContent> getContents() {
        return contents;
    }

    public void setContents(List<GeminiContent> contents) {
        this.contents = contents;
    }
}

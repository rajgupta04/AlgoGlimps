package com.example.demo.llm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiCandidate {
    private GeminiContentResponse content;

    public GeminiCandidate() {
    }

    public GeminiContentResponse getContent() {
        return content;
    }

    public void setContent(GeminiContentResponse content) {
        this.content = content;
    }
}

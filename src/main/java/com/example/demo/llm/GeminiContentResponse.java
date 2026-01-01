package com.example.demo.llm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiContentResponse {
    private String role;
    private List<GeminiPartResponse> parts;

    public GeminiContentResponse() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<GeminiPartResponse> getParts() {
        return parts;
    }

    public void setParts(List<GeminiPartResponse> parts) {
        this.parts = parts;
    }
}

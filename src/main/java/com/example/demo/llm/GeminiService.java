package com.example.demo.llm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeminiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${gemini.api.key:}")
    private String apiKey;

    @Value("${gemini.api.url:https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent}")
    private String apiUrl;

    public String generateText(GeminiRequest request) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Gemini API key is not configured. Set GEMINI_API_KEY in the environment.");
        }
        String urlWithKey = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("key", apiKey)
                .toUriString();

        ResponseEntity<GeminiApiResponse> response = restTemplate.postForEntity(urlWithKey, request,
                GeminiApiResponse.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new IllegalStateException("Gemini API call failed with status " + response.getStatusCode());
        }

        GeminiApiResponse body = response.getBody();
        return extractText(body).orElseThrow(() -> new IllegalStateException("Gemini response had no text candidate"));
    }

    private Optional<String> extractText(GeminiApiResponse body) {
        if (body.getCandidates() == null) {
            return Optional.empty();
        }
        return body.getCandidates().stream()
                .map(GeminiCandidate::getContent)
                .filter(content -> content != null && content.getParts() != null)
                .flatMap(content -> content.getParts().stream())
                .map(GeminiPartResponse::getText)
                .filter(text -> text != null && !text.isBlank())
                .findFirst();
    }
}

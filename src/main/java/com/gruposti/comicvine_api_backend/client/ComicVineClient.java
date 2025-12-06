package com.gruposti.comicvine_api_backend.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ComicVineClient {

    private final WebClient webClient;
    private final String apiKey;
    private final String baseUrl;

    public ComicVineClient(WebClient webClient,
                           @Value("${comicvine.api.key}") String apiKey,
                           @Value("${comicvine.api.base-url}") String baseUrl) {
        this.webClient = webClient;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public WebClient.RequestHeadersSpec<?> buildRequest(String resourcePath, int limit) {

        URI uri = UriComponentsBuilder.fromUriString(baseUrl)
                .path("/api" + resourcePath)
                .queryParam("api_key", apiKey)
                .queryParam("format", "json")
                .queryParam("limit", limit)
                .build()
                .toUri();

        return webClient.get().uri(uri);
    }

    public WebClient.RequestHeadersSpec<?> buildRequest(String resourcePath) {
        URI uri = UriComponentsBuilder.fromUriString(baseUrl)
                .path("/api" + resourcePath)
                .queryParam("api_key", apiKey)
                .queryParam("format", "json")
                .build()
                .toUri();

        return webClient.get().uri(uri);
    }

}

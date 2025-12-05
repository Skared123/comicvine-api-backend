package com.gruposti.comicvine_api_backend.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ComicVineClient {

    private final WebClient webClient;
    private final String apiKey;

    public ComicVineClient(WebClient webClient,
                           @Value("${comicvine.api.key}") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    public WebClient.RequestHeadersSpec<?> buildRequest(String resourcePath) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(resourcePath)
                        .queryParam("api_key", apiKey)
                        .queryParam("format", "json")
                        .build()
                );
    }

}

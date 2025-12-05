package com.gruposti.comicvine_api_backend.client.response;

import lombok.Data;
import java.util.List;

@Data
public class ComicVineCharacterResponse {

    private String error;
    private int limit;
    private int offset;
    private int number_of_page_results;

    private List<CharacterResult> results;

    @Data
    public static class CharacterResult {
        private int id;
        private String name;
        private String deck;
        private Image image;
    }

    @Data
    public static class Image {
        private String super_url;
        private String screen_url;
    }
}

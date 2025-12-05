package com.gruposti.comicvine_api_backend.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.util.List;

@Data
@JsonPropertyOrder({"type", "action", "data"})
public class CharacterListResponseDTO {

    private final String type = "SUCCESS";
    private final String action = "CONTINUE";
    private CharacterListData data;

    @Data
    @JsonPropertyOrder({"items", "characters"})
    public static class CharacterListData {
        private int items;
        private List<Character> characters;
    }

    @Data
    @JsonPropertyOrder({"id", "name", "description", "image"})
    public static class Character {
        private int id;
        private String name;
        private String description;
        private String image;
    }
}
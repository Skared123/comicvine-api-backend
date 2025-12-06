package com.gruposti.comicvine_api_backend.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder({"type", "action", "data"})
public class CharacterDetailsResponseDTO {

    private final String type = "SUCCESS";
    private final String action = "CONTINUE";

    private CharacterDetailsData data;

    @Data
    @JsonPropertyOrder({"id","name","description","image","comics"})
    public static class CharacterDetailsData {
        private int id;
        private String name;
        private String description;
        private String image;

        private List<Comic> comics;
    }

    @Data
    public static class Comic {
        private String name;
    }
}

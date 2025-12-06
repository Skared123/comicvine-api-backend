package com.gruposti.comicvine_api_backend.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ComicVineCharacterDetailResponse {

    private String status_code;
    private String error;
    private int limit;
    private int offset;

    @JsonProperty("number_of_total_results")
    private int numberOfTotalResults;

    @JsonProperty("number_of_page_results")
    private int numberOfPageResults;

    private String version;

    private CharacterDetail results;

    @Data
    public static class CharacterDetail {
        private int id;
        private String name;
        private String deck;
        private String description;
        private Image image;

        @JsonProperty("issue_credits")
        private List<IssueCredit> issueCredits;
    }

    @Data
    public static class IssueCredit {
        private int id;
        private String name;
    }

    @Data
    public static class Image {
        @JsonProperty("icon_url")
        private String iconUrl;

        @JsonProperty("medium_url")
        private String mediumUrl;

        @JsonProperty("screen_url")
        private String screenUrl;

        @JsonProperty("screen_large_url")
        private String screenLargeUrl;

        @JsonProperty("small_url")
        private String smallUrl;

        @JsonProperty("super_url")
        private String superUrl;

        @JsonProperty("thumb_url")
        private String thumbUrl;

        @JsonProperty("tiny_url")
        private String tinyUrl;

        @JsonProperty("original_url")
        private String originalUrl;

        @JsonProperty("image_tags")
        private String imageTags;
    }
}

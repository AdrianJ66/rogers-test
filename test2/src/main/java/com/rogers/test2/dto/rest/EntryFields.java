package com.rogers.test2.dto.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryFields {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("canonicalUrl")
    private String canonicalURL;

    @JsonProperty("isNoIndex")
    private String isNoIndex;

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + canonicalURL + '\'' +
                ", isNoIndex=" + isNoIndex +
                '}';
    }
}

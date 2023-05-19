package com.rogers.test2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EntryFields {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("canonicalUrl")
    private String canonicalURL;

    @JsonProperty("isNoIndex")
    private Boolean isNoIndex;

}

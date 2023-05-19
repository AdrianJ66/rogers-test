package com.rogers.test2.dto.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
    @JsonProperty("includes")
    private Includes includes;

    @Override
    public String toString() {
        return "" + includes;
    }
}
package com.rogers.test2.dto.rest;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {
    @JsonProperty("fields")
    private EntryFields fields;

    @Override
    public String toString() {
        return "" + fields;
    }
}

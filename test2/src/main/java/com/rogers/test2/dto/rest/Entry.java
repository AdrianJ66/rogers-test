package com.rogers.test2.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Entry {
    @JsonProperty("fields")
    private EntryFields fields;

}

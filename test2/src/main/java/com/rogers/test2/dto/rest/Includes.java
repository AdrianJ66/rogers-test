package com.rogers.test2.dto.rest;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Includes {

    @JsonProperty("Entry")
    private List<Entry> entry;

    @Override
    public String toString() {
        return "" + entry;
    }
}

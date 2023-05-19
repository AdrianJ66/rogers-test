package com.rogers.test2.dto.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Welcome {
    @JsonProperty("includes")
    private Includes includes;
}
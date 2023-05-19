package com.rogers.test2.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Includes {

    @JsonProperty("Entry")
    private List<Entry> entry;



}

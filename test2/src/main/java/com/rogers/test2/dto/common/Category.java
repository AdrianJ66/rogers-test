package com.rogers.test2.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @JsonProperty("1.")
    private String categoryName;
    @JsonProperty("2.")
    private String subCategoryName;

}

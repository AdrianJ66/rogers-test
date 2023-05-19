package com.rogers.test2.dto.graphql;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class SEO {
    private String title;
    private String description;
    private boolean isNoIndex;
}

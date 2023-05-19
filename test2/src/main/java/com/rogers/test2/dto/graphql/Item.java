package com.rogers.test2.dto.graphql;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String url;
    private SEO seo;

    public Item(String url, String title, String description, boolean isNoIndex) {
        this.url = url;
        this.seo = new SEO(title, description, isNoIndex);
    }


}

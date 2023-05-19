package com.rogers.test2.dto.common;

import com.rogers.test2.dto.graphql.Item;
import lombok.Data;

import java.util.Objects;

@Data
public class PageTemplate {
    private String url;
    private String title;
    private String description;
    private Boolean isNoIndex;

    public void setFromItem(Item item) {
        var seo = item.getSeo();
        var seoPresent = Objects.nonNull(seo);
        this.setUrl(item.getUrl());
        this.setTitle(seoPresent ? seo.getTitle() : null);
        this.setDescription(seoPresent? seo.getDescription() : null);
        this.setIsNoIndex(seoPresent ? seo.isNoIndex() : null);
    }

    public PageTemplate(Item item) {
        var seo = item.getSeo();
        var seoPresent = Objects.nonNull(seo);
        this.setUrl(item.getUrl());
        this.setTitle(seoPresent ? seo.getTitle() : null);
        this.setDescription(seoPresent? seo.getDescription() : null);
        this.setIsNoIndex(seoPresent ? seo.isNoIndex() : null);
    }
}

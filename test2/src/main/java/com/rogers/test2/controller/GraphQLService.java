package com.rogers.test2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rogers.test2.dto.graphql.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GraphQLService {

    private final HttpGraphQlClient graphQlClient;

    private String getSupportPageTemplateQuery() {
        return """
                 query {
                    pageTemplateCollection(where: {url: "/support"}) {
                      items {
                        url
                        seo {
                          title
                          description
                          isNoIndex
                        }
                      }
                    }
                  }
                """;
    }

    private String getAllPageTemplatesQuery() {
        return """
                query {
                  pageTemplateCollection(limit:null, where: {seo_exists: true, seo: {sys: {id_exists: true}}}) {
                    total
                    items {
                      url
                      seo {
                        title
                        description
                        isNoIndex
                      }
                    }
                  }
                }
                """;
    }

    private Mono<List<Item>> getPageTemplate(String query) {
        return graphQlClient.document(query)
                .retrieve("pageTemplateCollection.items")
                .toEntityList(Item.class);
    }

    public Mono<List<Item>> getSupportPageTemplate() {
        return getPageTemplate(getSupportPageTemplateQuery());
    }

    public Mono<List<Item>> getAllPageTemplates() {
        return getPageTemplate(getAllPageTemplatesQuery());
    }

}

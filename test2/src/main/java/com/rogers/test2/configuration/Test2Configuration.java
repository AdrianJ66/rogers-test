package com.rogers.test2.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.rogers.test2.controller.GraphQLService;
import com.rogers.test2.dto.common.PageTemplate;
import com.rogers.test2.dto.rest.Metadata;
import com.rogers.test2.serializer.PageTemplateSerializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Configuration
public class Test2Configuration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://graphql.contentful.com/content/v1/spaces/8utyj17y1gom/environments/master?access_token=e50d8ac79fd7a3545d8c0049c6a1216f5d358a192467c77584eca6fad21e0f37")
                .build();
    }

    @Bean
    public HttpGraphQlClient httpGraphQlClient(WebClient webClient) {
        return HttpGraphQlClient.builder(webClient)
                .headers(httpHeaders -> httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_GRAPHQL_RESPONSE)))
                .build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        var module = new SimpleModule("PageTemplateSerializer");
        module.addSerializer(new PageTemplateSerializer(PageTemplate.class));

        return new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .registerModule(module);
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, GraphQLService graphQLService, ObjectMapper objectMapper) throws Exception {
        return args -> {
            //ex 2
            var result = restTemplate.getForObject(
                    "https://cdn.contentful.com/spaces/8utyj17y1gom/entries?access_token=e50d8ac79fd7a3545d8c0049c6" +
                            "a1216f5d358a192467c77584eca6fad21e0f37&content_type=pageTemplate&include=1&fields.url=/support", Metadata.class);
            System.out.println(result);
            System.out.println("-----------------------------------------------------------------------------------------------");


            //ex3
            var result2 = graphQLService.getSupportPageTemplate();
            result2.subscribe(support -> {
                try {
                    System.out.println(objectMapper.writeValueAsString(new PageTemplate(support.get(0))));
                    System.out.println("-----------------------------------------------------------------------------------------------");
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });



            //ex4 and ex5
            var result3 = graphQLService.getAllPageTemplates();
            result3.subscribe(all -> {
                all.stream().map(PageTemplate::new).forEach(pt -> {
                    try {
                        System.out.print(objectMapper.writeValueAsString(pt));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("-----------------------------------------------------------------------------------------------");
            });

        };
    }
}

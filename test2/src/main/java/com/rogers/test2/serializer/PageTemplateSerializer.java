package com.rogers.test2.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.rogers.test2.dto.common.PageTemplate;
import com.rogers.test2.parser.PageTemplateFieldParser;

import java.io.IOException;


public class PageTemplateSerializer extends StdSerializer<PageTemplate> {

    private final PageTemplateFieldParser parser = new PageTemplateFieldParser();

    public PageTemplateSerializer(Class<PageTemplate> t) {
        super(t);
    }

    public PageTemplateSerializer(JavaType type) {
        super(type);
    }

    @Override
    public void serialize(PageTemplate pageTemplate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("url", parser.parseUrl(pageTemplate.getUrl()));
        jsonGenerator.writeStringField("title", parser.parseTitle(pageTemplate.getTitle()));
        jsonGenerator.writeStringField("description", parser.parseDescription(pageTemplate.getDescription()));
        jsonGenerator.writeStringField("isNoIndex", parser.parseIsNoIndex(pageTemplate.getIsNoIndex()));
        jsonGenerator.writeStringField("category", parser.parseCategory(pageTemplate.getUrl()));
        jsonGenerator.writeEndObject();
    }


}

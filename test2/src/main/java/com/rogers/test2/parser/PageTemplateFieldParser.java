package com.rogers.test2.parser;

import com.rogers.test2.dto.common.Category;

import java.util.Objects;
import java.util.regex.Pattern;

public class PageTemplateFieldParser {
    public String parseUrl(String original) {
        if (Objects.isNull(original))
            return null;
        return original.replace("/home/", "https://www.rogers.com/");
    }

    public String parseTitle(String original) {
        if (Objects.isNull(original))
            return null;

        var version1 = original.replace("| Rogers", "");
        return version1.replace("- Rogers", "").stripTrailing();
    }

    public String parseDescription(String original) {
        if (Objects.isNull(original))
            return null;

        return original.length() > 80 ? original.substring(0, 80) : original;
    }

    public String parseIsNoIndex(Boolean original) {
        return Objects.isNull(original) ? "null" : original.toString();
    }

    public Category parseCategory(String original) {
        if (Objects.isNull(original))
            return new Category();

        var pattern = "\\/home\\/(.*?)\\/(.*)";
        var regex = Pattern.compile(pattern);
        var matcher = regex.matcher(original);

        String group1;
        try {
            group1 = capitalizeFirstLetter(matcher.group(1));
        } catch (Exception e) {
            group1 = "null";
        }

        String group2;
        try {
            group2 = capitalizeFirstLetter(matcher.group(2));
        } catch (Exception e) {
            group2 = "null";
        }

        return new Category(group1, group2);
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

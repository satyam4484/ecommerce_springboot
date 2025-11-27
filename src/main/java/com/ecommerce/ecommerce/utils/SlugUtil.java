package com.ecommerce.ecommerce.utils;

import org.springframework.stereotype.Component;

@Component
public class SlugUtil {

    public String toSlug(String input) {
        return input.toLowerCase()
                .trim()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", "");
    }
}

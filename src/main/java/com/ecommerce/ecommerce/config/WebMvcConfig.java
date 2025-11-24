package com.ecommerce.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${app.api.base-path}")
    private String apiBasePath;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer
                .setPatternParser(new PathPatternParser())
                .addPathPrefix(apiBasePath,
                        controllerClass ->
                                controllerClass.getPackageName()
                                        .startsWith("com.ecommerce.ecommerce.controller")
                );
    }
}

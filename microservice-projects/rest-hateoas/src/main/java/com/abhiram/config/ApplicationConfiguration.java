package com.abhiram.config;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.content.rest.config.

@Configuration
public class ApplicationConfiguration {

    @Bean
    RestTemplateCustomizer restTemplateCustomizer(
            HypermediaRestTemplateConfigurer configurer) {
        return restTemplate -> {
            configurer.registerHypermediaTypes(restTemplate);
        };
    }
}

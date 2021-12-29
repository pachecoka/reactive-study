package com.study.webflux.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public ObjectMapper getObjectMapper() {
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }

}

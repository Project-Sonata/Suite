package com.odeyalo.sonata.suite.reactive.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.suite.reactive.config.support.BadRequestReactiveStatusHandler;
import org.springframework.context.annotation.Bean;

public class ReactiveFeignConfiguration {


    @Bean
    public BadRequestReactiveStatusHandler badRequestReactiveStatusHandler(ObjectMapper mapper) {
        return new BadRequestReactiveStatusHandler(mapper);
    }

}

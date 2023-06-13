package com.odeyalo.sonata.common.authentication.config.reactive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.common.authentication.config.reactive.support.BadRequestReactiveStatusHandler;
import org.springframework.context.annotation.Bean;

public class ReactiveFeignConfiguration {


    @Bean
    public BadRequestReactiveStatusHandler badRequestReactiveStatusHandler(ObjectMapper mapper) {
        return new BadRequestReactiveStatusHandler(mapper);
    }

}

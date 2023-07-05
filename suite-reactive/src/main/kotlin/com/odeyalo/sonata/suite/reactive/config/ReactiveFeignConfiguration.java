package com.odeyalo.sonata.suite.reactive.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.suite.reactive.config.support.AllErrorsReactiveStatusHandler;
import com.odeyalo.sonata.suite.reactive.exception.decoder.registry.ClientMethodExceptionHandlerDecoderRegistry;
import org.springframework.context.annotation.Bean;

public class ReactiveFeignConfiguration {

    @Bean
    public AllErrorsReactiveStatusHandler allErrorsReactiveStatusHandler(ObjectMapper mapper, ClientMethodExceptionHandlerDecoderRegistry registry) {
        return new AllErrorsReactiveStatusHandler(mapper, registry);
    }
}

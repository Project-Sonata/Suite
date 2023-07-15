package com.odeyalo.sonata.suite.reactive.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.suite.reactive.config.support.AllErrorsReactiveStatusHandler;
import com.odeyalo.sonata.suite.reactive.config.support.interceptor.CompositeReactiveHttpRequestInterceptor;
import com.odeyalo.sonata.suite.reactive.config.support.interceptor.SuiteReactiveHttpRequestInterceptor;
import com.odeyalo.sonata.suite.reactive.exception.decoder.registry.ClientMethodExceptionHandlerDecoderRegistry;
import org.springframework.context.annotation.Bean;
import reactivefeign.client.ReactiveHttpRequestInterceptor;

import java.util.List;

public class ReactiveFeignConfiguration {

    @Bean
    public AllErrorsReactiveStatusHandler allErrorsReactiveStatusHandler(ObjectMapper mapper, ClientMethodExceptionHandlerDecoderRegistry registry) {
        return new AllErrorsReactiveStatusHandler(mapper, registry);
    }

    @Bean
    public ReactiveHttpRequestInterceptor reactiveHttpRequestInterceptor(List<SuiteReactiveHttpRequestInterceptor> interceptors) {
        return new CompositeReactiveHttpRequestInterceptor(interceptors);
    }
}

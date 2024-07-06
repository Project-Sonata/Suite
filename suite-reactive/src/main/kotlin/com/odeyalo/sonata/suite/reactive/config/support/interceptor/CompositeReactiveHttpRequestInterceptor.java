package com.odeyalo.sonata.suite.reactive.config.support.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactivefeign.client.ReactiveHttpRequest;
import reactivefeign.client.ReactiveHttpRequestInterceptor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class CompositeReactiveHttpRequestInterceptor implements ReactiveHttpRequestInterceptor {
    private final List<SuiteReactiveHttpRequestInterceptor> interceptors;
    private final Logger logger = LoggerFactory.getLogger(CompositeReactiveHttpRequestInterceptor.class);

    public CompositeReactiveHttpRequestInterceptor(List<SuiteReactiveHttpRequestInterceptor> interceptors) {
        this.interceptors = interceptors;
        this.logger.info("Initialized interceptors with: {}", interceptors);
    }

    @Override
    public Mono<ReactiveHttpRequest> apply(ReactiveHttpRequest reactiveHttpRequest) {
        return Flux.fromIterable(interceptors)
                .flatMap(interceptor -> interceptor.apply(reactiveHttpRequest))
                .next()
                .defaultIfEmpty(reactiveHttpRequest);
    }
}

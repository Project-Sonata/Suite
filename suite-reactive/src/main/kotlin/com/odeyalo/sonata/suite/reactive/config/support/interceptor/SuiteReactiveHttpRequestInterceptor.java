package com.odeyalo.sonata.suite.reactive.config.support.interceptor;

import reactivefeign.client.ReactiveHttpRequest;
import reactor.core.publisher.Mono;

public interface SuiteReactiveHttpRequestInterceptor {
    Mono<ReactiveHttpRequest> apply(ReactiveHttpRequest reactiveHttpRequest);
}

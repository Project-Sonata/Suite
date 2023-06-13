package com.odeyalo.sonata.suite.reactive.config;

import org.springframework.context.annotation.Bean;
import reactivefeign.client.ReactiveHttpResponse;
import reactivefeign.client.statushandler.ReactiveStatusHandler;
import reactor.core.publisher.Mono;

public class ReactiveSonataResponseErrorDecoder implements ReactiveStatusHandler {

    @Override
    public boolean shouldHandle(int i) {
        return false;
    }

    @Override
    public Mono<? extends Throwable> decode(String s, ReactiveHttpResponse<?> reactiveHttpResponse) {
        return null;
    }
}

package com.odeyalo.sonata.suite.reactive.config.support;

import com.odeyalo.sonata.suite.reactive.exception.decoder.registry.ClientMethodExceptionHandlerDecoderRegistry;
import reactivefeign.client.ReactiveHttpResponse;
import reactivefeign.client.statushandler.ReactiveStatusHandler;
import reactor.core.publisher.Mono;

/**
 * {@link ReactiveStatusHandler} that handles only HTTP errors (from 400 to 600 code).
 */
public class AllErrorsReactiveStatusHandler implements ReactiveStatusHandler {
    private final ClientMethodExceptionHandlerDecoderRegistry container;

    public AllErrorsReactiveStatusHandler(ClientMethodExceptionHandlerDecoderRegistry container) {
        this.container = container;
    }

    @Override
    public boolean shouldHandle(int status) {
        return status >= 400 && status < 600;
    }

    @Override
    public Mono<? extends Throwable> decode(String methodName, ReactiveHttpResponse<?> reactiveHttpResponse) {
        return container.getDecoder(methodName, true).handleException(methodName, reactiveHttpResponse);
    }
}

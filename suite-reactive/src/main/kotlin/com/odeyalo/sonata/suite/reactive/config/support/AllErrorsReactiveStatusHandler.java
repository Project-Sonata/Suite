package com.odeyalo.sonata.suite.reactive.config.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.suite.reactive.exception.decoder.registry.ClientMethodExceptionHandlerDecoderRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactivefeign.client.ReactiveHttpResponse;
import reactivefeign.client.statushandler.ReactiveStatusHandler;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * ReactiveStatusHandler that handles only HTTP 400 error.
 */
public class AllErrorsReactiveStatusHandler implements ReactiveStatusHandler {
    private final ClientMethodExceptionHandlerDecoderRegistry container;
    protected final ObjectMapper objectMapper;
    protected final Logger logger = LoggerFactory.getLogger(AllErrorsReactiveStatusHandler.class);

    public AllErrorsReactiveStatusHandler(ObjectMapper objectMapper, ClientMethodExceptionHandlerDecoderRegistry container) {
        System.out.println("created error decoder");
        this.objectMapper = objectMapper;
        this.container = container;
    }

    @Override
    public boolean shouldHandle(int status) {
        return status >= 400;
    }

    @Override
    public Mono<? extends Throwable> decode(String methodName, ReactiveHttpResponse<?> reactiveHttpResponse) {
        return container.getDecoder(methodName, true).handleException(methodName, reactiveHttpResponse);
    }

    protected <T> Mono<T> parse(byte[] bytes, Class<T> target) {
        try {
            return Mono.just(objectMapper.readValue(bytes, target));
        } catch (IOException e) {
            logger.error(String.format("An error was occurred during JSON parsing. Target class: %s\n", target.getName()), e);
            return Mono.error(e);
        }
    }
}

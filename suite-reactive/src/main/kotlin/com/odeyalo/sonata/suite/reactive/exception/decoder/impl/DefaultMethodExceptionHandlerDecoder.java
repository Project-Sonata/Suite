package com.odeyalo.sonata.suite.reactive.exception.decoder.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.suite.reactive.exception.UnrecognizedResponseException;
import com.odeyalo.sonata.suite.reactive.exception.decoder.AbstractReactiveFeignClientMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.DetaultReactiveFeignClientMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.ReactiveFeignClientMethodExceptionHandlerDecoder;
import org.springframework.stereotype.Component;
import reactivefeign.client.ReactiveHttpResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Default implementation for {@link ReactiveFeignClientMethodExceptionHandlerDecoder} that just wraps the body in the exception
 */
public class DefaultMethodExceptionHandlerDecoder extends AbstractReactiveFeignClientMethodExceptionHandlerDecoder implements DetaultReactiveFeignClientMethodExceptionHandlerDecoder {

    public DefaultMethodExceptionHandlerDecoder(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    public Mono<? extends Throwable> handleException(String methodName, ReactiveHttpResponse<?> response) {
        return response.bodyData()
                .flatMap(bytes -> parse(bytes, Map.class))
                .flatMap(body -> Mono.error(new UnrecognizedResponseException(response, body)));
    }

    @Override
    protected Method[] doGetSupportedMethods() {
        return new Method[0];
    }
}

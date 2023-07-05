package com.odeyalo.sonata.suite.reactive.exception;

import reactivefeign.client.ReactiveHttpResponse;

import java.util.Map;

/**
 * Runtime exception that will be thrown when response is unknown and cannot be converted in the default way
 */
public class UnrecognizedResponseException extends RuntimeException {
    private final ReactiveHttpResponse<?> response;
    private final Map<String, Object> body;

    public UnrecognizedResponseException(ReactiveHttpResponse<?> response, Map<String, Object> body) {
        this.response = response;
        this.body = body;
    }

    public ReactiveHttpResponse<?> getStatus() {
        return response;
    }

    public Map<String, Object> getBody() {
        return body;
    }
}

package com.odeyalo.sonata.suite.reactive.config.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.common.authentication.dto.response.AuthenticationResultResponse;
import com.odeyalo.sonata.common.authentication.exception.InvalidCredentialsException;
import com.odeyalo.sonata.common.shared.GenericApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactivefeign.client.ReactiveHttpResponse;
import reactivefeign.client.statushandler.ReactiveStatusHandler;
import reactivefeign.utils.HttpStatus;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static com.odeyalo.sonata.common.authentication.AuthenticationErrorCodes.INVALID_CREDENTIALS;

/**
 * ReactiveStatusHandler that handles only HTTP 400 error.
 */
public class BadRequestReactiveStatusHandler implements ReactiveStatusHandler {
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(BadRequestReactiveStatusHandler.class);

    public BadRequestReactiveStatusHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean shouldHandle(int status) {
        return status == HttpStatus.SC_BAD_REQUEST;
    }

    @Override
    public Mono<? extends Throwable> decode(String s, ReactiveHttpResponse<?> reactiveHttpResponse) {
        return reactiveHttpResponse.bodyData()
                .flatMap(this::parse)
                .map(details -> {
                    switch (details.getErrorDetails().getCode()) {
                        case (INVALID_CREDENTIALS):
                            logger.info("Parsed to INVALID_CREDENTIALS: " + details);
                            return (new InvalidCredentialsException(details.getErrorDetails()));
                    }
                    return (new GenericApiException(details.getErrorDetails()));
                });
    }

    private Mono<AuthenticationResultResponse> parse(byte[] bytes) {
        try {
            return Mono.just(objectMapper.readValue(bytes, AuthenticationResultResponse.class));
        } catch (IOException e) {
            logger.error("There is an error", e);
            return Mono.error(e);
        }
    }
}

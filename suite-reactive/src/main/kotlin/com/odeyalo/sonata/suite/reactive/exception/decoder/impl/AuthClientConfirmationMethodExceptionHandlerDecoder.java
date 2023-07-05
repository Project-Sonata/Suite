package com.odeyalo.sonata.suite.reactive.exception.decoder.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.common.authentication.dto.request.ConfirmationCodeRequestDto;
import com.odeyalo.sonata.common.authentication.dto.response.EmailConfirmationStatusResponseDto;
import com.odeyalo.sonata.common.authentication.exception.ConfirmationCodeException;
import com.odeyalo.sonata.suite.reactive.client.ReactiveAuthenticationClient;
import com.odeyalo.sonata.suite.reactive.exception.decoder.AbstractReactiveFeignClientMethodExceptionHandlerDecoder;
import feign.Feign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import reactivefeign.client.ReactiveHttpResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Handles only the {@link ReactiveAuthenticationClient#confirmEmail(ConfirmationCodeRequestDto)} method and wrap it to
 * {@link ConfirmationCodeException}
 */
public class AuthClientConfirmationMethodExceptionHandlerDecoder extends AbstractReactiveFeignClientMethodExceptionHandlerDecoder {

    public AuthClientConfirmationMethodExceptionHandlerDecoder(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    protected Method[] doGetSupportedMethods() {
        return new Method[] {
                ReflectionUtils.findMethod(ReactiveAuthenticationClient.class, "confirmEmail", ConfirmationCodeRequestDto.class)
        };
    }

    @Override
    public Mono<? extends Throwable> handleException(String methodName, ReactiveHttpResponse<?> reactiveHttpResponse) {
        return reactiveHttpResponse.bodyData()
                .flatMap(bytes -> parse(bytes, EmailConfirmationStatusResponseDto.class))
                .map(body ->
                        new ConfirmationCodeException(body.getMessage(), null)
                );
    }
}

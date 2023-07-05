package com.odeyalo.sonata.suite.reactive.exception.decoder.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.common.authentication.dto.LoginCredentials;
import com.odeyalo.sonata.common.authentication.dto.response.AuthenticationResultResponse;
import com.odeyalo.sonata.common.shared.ErrorDetails;
import com.odeyalo.sonata.suite.reactive.client.ReactiveAuthenticationClient;
import com.odeyalo.sonata.suite.reactive.exception.converter.ErrorCodeConvertersRegistry;
import com.odeyalo.sonata.suite.reactive.exception.decoder.AbstractReactiveFeignClientMethodExceptionHandlerDecoder;
import org.springframework.util.ReflectionUtils;
import reactivefeign.client.ReactiveHttpResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;

public class AuthClientLoginMethodExceptionHandlerDecoder extends AbstractReactiveFeignClientMethodExceptionHandlerDecoder {
    private final ErrorCodeConvertersRegistry codeConvertersRegistry;

    public AuthClientLoginMethodExceptionHandlerDecoder(ObjectMapper mapper, ErrorCodeConvertersRegistry codeConvertersRegistry) {
        super(mapper);
        this.codeConvertersRegistry = codeConvertersRegistry;
    }

    @Override
    protected Method[] doGetSupportedMethods() {
        return new Method[] {
                ReflectionUtils.findMethod(ReactiveAuthenticationClient.class, "login", LoginCredentials.class)
        };
    }

    @Override
    public Mono<? extends Throwable> handleException(String methodName, ReactiveHttpResponse<?> reactiveHttpResponse) {
        return reactiveHttpResponse.bodyData()
                .flatMap(bytes -> parse(bytes, AuthenticationResultResponse.class))
                .map(result -> {
                    ErrorDetails errorDetails = result.getErrorDetails();
                    return codeConvertersRegistry.getConverter(errorDetails.getCode()).convertToThrowable(methodName, errorDetails);
                });
    }
}

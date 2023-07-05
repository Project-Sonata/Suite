package com.odeyalo.sonata.suite.reactive.exception.decoder.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.common.authentication.AuthenticationErrorCodes;
import com.odeyalo.sonata.common.authentication.dto.request.UserRegistrationInfo;
import com.odeyalo.sonata.common.authentication.exception.InvalidEmailRegistrationFailedException;
import com.odeyalo.sonata.common.authentication.exception.RegistrationFailedException;
import com.odeyalo.sonata.common.shared.ApiErrorDetailsInfo;
import com.odeyalo.sonata.suite.reactive.client.ReactiveAuthenticationClient;
import com.odeyalo.sonata.suite.reactive.exception.converter.ErrorCode2ThrowableConverter;
import com.odeyalo.sonata.suite.reactive.exception.converter.ErrorCodeConvertersRegistry;
import com.odeyalo.sonata.suite.reactive.exception.decoder.AbstractReactiveFeignClientMethodExceptionHandlerDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import reactivefeign.client.ReactiveHttpResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;

public class AuthClientRegistrationMethodExceptionHandlerDecoder extends AbstractReactiveFeignClientMethodExceptionHandlerDecoder {
    private final ErrorCodeConvertersRegistry converters;

    public AuthClientRegistrationMethodExceptionHandlerDecoder(ObjectMapper mapper, ErrorCodeConvertersRegistry converters) {
        super(mapper);
        this.converters = converters;
    }

    @Override
    public Mono<? extends Throwable> handleException(String methodName, ReactiveHttpResponse<?> response) {
        return response.bodyData()
                .flatMap(body -> parse(body, ApiErrorDetailsInfo.class))
                .map(ApiErrorDetailsInfo::getErrorDetails)
                .flatMap(details -> {
                    ErrorCode2ThrowableConverter converter = converters.getConverter(details.getCode());

                    Throwable throwable = converter.convertToThrowable(methodName, details);

                    return Mono.error(throwable);
                });
    }

    @Override
    protected Method[] doGetSupportedMethods() {
        return new Method[] {
                ReflectionUtils.findMethod(ReactiveAuthenticationClient.class, "registerUser", UserRegistrationInfo.class)
        };
    }
}

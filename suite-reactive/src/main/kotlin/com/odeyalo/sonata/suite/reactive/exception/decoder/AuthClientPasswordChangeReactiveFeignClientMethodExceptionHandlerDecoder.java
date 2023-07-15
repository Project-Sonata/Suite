package com.odeyalo.sonata.suite.reactive.exception.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.common.authentication.dto.request.PasswordContainerDto;
import com.odeyalo.sonata.common.authentication.dto.response.PasswordUpdatingResultDto;
import com.odeyalo.sonata.common.authentication.exception.PasswordUpdatingFailedException;
import com.odeyalo.sonata.common.shared.ApiErrorDetailsInfo;
import com.odeyalo.sonata.common.shared.ErrorDetails;
import com.odeyalo.sonata.suite.reactive.client.ReactiveAuthenticationClient;
import org.springframework.util.ReflectionUtils;
import reactivefeign.client.ReactiveHttpResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;

public class AuthClientPasswordChangeReactiveFeignClientMethodExceptionHandlerDecoder extends AbstractReactiveFeignClientMethodExceptionHandlerDecoder {
    public AuthClientPasswordChangeReactiveFeignClientMethodExceptionHandlerDecoder(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    protected Method[] doGetSupportedMethods() {
        return new Method[]{
                ReflectionUtils.findMethod(ReactiveAuthenticationClient.class, "changePassword", String.class, PasswordContainerDto.class)
        };
    }

    @Override
    public Mono<? extends Throwable> handleException(String methodName, ReactiveHttpResponse<?> reactiveHttpResponse) {
        return reactiveHttpResponse.bodyData()
                .flatMap(bytes -> parse(bytes, PasswordUpdatingResultDto.class))
                .map(res -> new PasswordUpdatingFailedException(res.getErrorDetails()));
    }
}

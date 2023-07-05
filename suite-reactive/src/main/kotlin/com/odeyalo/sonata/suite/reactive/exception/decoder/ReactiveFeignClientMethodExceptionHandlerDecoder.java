package com.odeyalo.sonata.suite.reactive.exception.decoder;

import reactivefeign.client.ReactiveHttpResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;

/**
 * Handle the exception thrown by specific method
 */
public interface ReactiveFeignClientMethodExceptionHandlerDecoder {
    /**
     * Handle and decode the ReactiveHttpResponse that was failed.
     * Convert the response to specific {@link Throwable} implementation
     * @param methodName feign client method that throw exception
     * @param reactiveHttpResponse response that has 4xx or 5xx status code
     * @return - response wrapped in specific exception
     */
    Mono<? extends Throwable> handleException(String methodName, ReactiveHttpResponse<?> reactiveHttpResponse);

    /**
     * @return array of methods that this implementation can decode
     * Note, that supported method name must be in specific format.
     * See required format in {@link feign.Feign#configKey(Class, Method)})}
     */
    String[] supportedMethods();
}

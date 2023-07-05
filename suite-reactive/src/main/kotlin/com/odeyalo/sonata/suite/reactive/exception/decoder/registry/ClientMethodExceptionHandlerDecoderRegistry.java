package com.odeyalo.sonata.suite.reactive.exception.decoder.registry;

import com.odeyalo.sonata.suite.reactive.exception.decoder.ReactiveFeignClientMethodExceptionHandlerDecoder;

public interface ClientMethodExceptionHandlerDecoderRegistry {

    void addExceptionDecoder(String supportedMethodKey, ReactiveFeignClientMethodExceptionHandlerDecoder decoder);

    void addExceptionDecoder(String[] supportedMethodKeys, ReactiveFeignClientMethodExceptionHandlerDecoder decoder);

    default ReactiveFeignClientMethodExceptionHandlerDecoder getDecoder(String methodKey) {
        return getDecoder(methodKey, false);
    }

    ReactiveFeignClientMethodExceptionHandlerDecoder getDecoder(String methodKey, boolean returnDefault);

    boolean contains(String methodKey);
}

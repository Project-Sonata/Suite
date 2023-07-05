package com.odeyalo.sonata.suite.reactive.exception.decoder;

/**
 * More specific interface for {@link ReactiveFeignClientMethodExceptionHandlerDecoder} that uses as default handler if no other handler was found
 */
public interface DetaultReactiveFeignClientMethodExceptionHandlerDecoder extends ReactiveFeignClientMethodExceptionHandlerDecoder {

    @Override
    default String[] supportedMethods() {
        return new String[0];
    }
}

package com.odeyalo.sonata.suite.reactive.exception.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class AbstractReactiveFeignClientMethodExceptionHandlerDecoder implements ReactiveFeignClientMethodExceptionHandlerDecoder {
    protected final ObjectMapper mapper;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected AbstractReactiveFeignClientMethodExceptionHandlerDecoder(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    protected abstract Method[] doGetSupportedMethods();

    @Override
    public final String[] supportedMethods() {
        return Arrays.stream(doGetSupportedMethods())
                .peek(method -> {
                    if (method == null) {
                        throw new IllegalStateException("There is a null method provided in: " + this.getClass());
                    }
                })
                .map(method -> Feign.configKey(method.getDeclaringClass(), method))
                .toArray(String[]::new);
    }

    protected <T> Mono<T> parse(byte[] bytes, Class<T> target) {
        try {
            return Mono.just(mapper.readValue(bytes, target));
        } catch (IOException e) {
            logger.error(String.format("Error during parsing JSON to target class: %s", target.getName()), e);
            return Mono.error(e);
        }
    }
}

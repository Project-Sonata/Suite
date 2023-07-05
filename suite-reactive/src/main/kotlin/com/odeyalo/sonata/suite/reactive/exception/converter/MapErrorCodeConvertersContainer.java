package com.odeyalo.sonata.suite.reactive.exception.converter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class MapErrorCodeConvertersContainer implements ErrorCodeConvertersRegistry {
    private final ConcurrentMap<String, ErrorCode2ThrowableConverter> converters;

    public MapErrorCodeConvertersContainer() {
        this.converters = new ConcurrentHashMap<>();
    }

    public MapErrorCodeConvertersContainer(List<ErrorCode2ThrowableConverter> converters) {
        Map<String, ErrorCode2ThrowableConverter> map = converters.stream()
                .collect(Collectors.toMap(ErrorCode2ThrowableConverter::getSupportedErrorCode, converter -> converter));

        this.converters = new ConcurrentHashMap<>(map);
    }

    public MapErrorCodeConvertersContainer(ConcurrentMap<String, ErrorCode2ThrowableConverter> converters) {
        this.converters = converters;
    }

    @Override
    public void addConverter(String errorCode, ErrorCode2ThrowableConverter converter) {
        converters.put(errorCode, converter);
    }

    @Override
    public ErrorCode2ThrowableConverter getConverter(String errorCode) {
        return converters.get(errorCode);
    }

    @Override
    public boolean contains(String errorCode) {
        return converters.containsKey(errorCode);
    }
}

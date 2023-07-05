package com.odeyalo.sonata.suite.reactive.exception.converter;

public interface ErrorCodeConvertersRegistry {

    void addConverter(String errorCode, ErrorCode2ThrowableConverter converter);

    ErrorCode2ThrowableConverter getConverter(String errorCode);

    boolean contains(String errorCode);
}

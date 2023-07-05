package com.odeyalo.sonata.suite.reactive.exception.converter;

import com.odeyalo.sonata.common.shared.ErrorDetails;

public interface ErrorCode2ThrowableConverter {

    Throwable convertToThrowable(String methodName, ErrorDetails errorDetails);

    String getSupportedErrorCode();
}

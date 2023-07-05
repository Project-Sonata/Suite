package com.odeyalo.sonata.suite.reactive.exception.converter;

import com.odeyalo.sonata.common.authentication.AuthenticationErrorCodes;
import com.odeyalo.sonata.common.authentication.exception.InvalidEmailRegistrationFailedException;
import com.odeyalo.sonata.common.shared.ErrorDetails;

public class InvalidEmailErrorCode2ThrowableConverter implements ErrorCode2ThrowableConverter {

    @Override
    public Throwable convertToThrowable(String methodName, ErrorDetails errorDetails) {
        return new InvalidEmailRegistrationFailedException(errorDetails);
    }

    @Override
    public String getSupportedErrorCode() {
        return AuthenticationErrorCodes.INVALID_EMAIL;
    }
}

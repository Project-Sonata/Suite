package com.odeyalo.sonata.suite.reactive.exception.converter;

import com.odeyalo.sonata.common.authentication.AuthenticationErrorCodes;
import com.odeyalo.sonata.common.authentication.exception.InvalidPasswordRegistrationFailedException;
import com.odeyalo.sonata.common.shared.ErrorDetails;

public class InvalidPasswordErrorCode2ThrowableConverter implements ErrorCode2ThrowableConverter {

    @Override
    public Throwable convertToThrowable(String methodName, ErrorDetails errorDetails) {
        return new InvalidPasswordRegistrationFailedException(errorDetails);
    }

    @Override
    public String getSupportedErrorCode() {
        return AuthenticationErrorCodes.INVALID_PASSWORD;
    }
}

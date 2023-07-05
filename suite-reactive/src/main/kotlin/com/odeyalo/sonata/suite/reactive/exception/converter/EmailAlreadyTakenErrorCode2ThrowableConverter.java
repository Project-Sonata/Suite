package com.odeyalo.sonata.suite.reactive.exception.converter;

import com.odeyalo.sonata.common.authentication.AuthenticationErrorCodes;
import com.odeyalo.sonata.common.authentication.exception.EmailAlreadyTakenRegistrationFailedException;
import com.odeyalo.sonata.common.shared.ErrorDetails;

public class EmailAlreadyTakenErrorCode2ThrowableConverter implements ErrorCode2ThrowableConverter {
    @Override
    public Throwable convertToThrowable(String methodName, ErrorDetails errorDetails) {
        return new EmailAlreadyTakenRegistrationFailedException(errorDetails);
    }

    @Override
    public String getSupportedErrorCode() {
        return AuthenticationErrorCodes.EMAIL_ALREADY_TAKEN;
    }
}

package com.odeyalo.sonata.suite.reactive.exception.converter;

import com.odeyalo.sonata.common.authentication.AuthenticationErrorCodes;
import com.odeyalo.sonata.common.authentication.exception.EmailConfirmationRequiredException;
import com.odeyalo.sonata.common.shared.ErrorDetails;

public class EmailConfirmationRequiredErrorCode2ThrowableConverter implements ErrorCode2ThrowableConverter {
    @Override
    public Throwable convertToThrowable(String methodName, ErrorDetails errorDetails) {
        return new EmailConfirmationRequiredException(errorDetails);
    }

    @Override
    public String getSupportedErrorCode() {
        return AuthenticationErrorCodes.EMAIL_CONFIRMATION_REQUIRED;
    }
}

package com.odeyalo.sonata.sonata.common.authentication.exception;

import com.odeyalo.sonata.sonata.common.shared.ErrorDetails;
import com.odeyalo.sonata.sonata.common.shared.GenericApiException;

public class LoginAuthenticationFailedException extends GenericApiException {
    public LoginAuthenticationFailedException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public LoginAuthenticationFailedException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public LoginAuthenticationFailedException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

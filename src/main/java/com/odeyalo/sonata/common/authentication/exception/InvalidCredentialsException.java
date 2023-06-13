package com.odeyalo.sonata.common.authentication.exception;

import com.odeyalo.sonata.common.shared.ErrorDetails;

public class InvalidCredentialsException extends LoginAuthenticationFailedException {

    public InvalidCredentialsException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public InvalidCredentialsException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public InvalidCredentialsException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

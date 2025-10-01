package com.odeyalo.sonata.common.authentication.exception;

import com.odeyalo.sonata.common.shared.ErrorDetails;

public class InvalidEmailRegistrationFailedException extends RegistrationFailedException {
    public InvalidEmailRegistrationFailedException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public InvalidEmailRegistrationFailedException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public InvalidEmailRegistrationFailedException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

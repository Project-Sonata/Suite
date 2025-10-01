package com.odeyalo.sonata.common.authentication.exception;

import com.odeyalo.sonata.common.shared.ErrorDetails;

public class InvalidPasswordRegistrationFailedException extends RegistrationFailedException {

    public InvalidPasswordRegistrationFailedException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public InvalidPasswordRegistrationFailedException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public InvalidPasswordRegistrationFailedException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

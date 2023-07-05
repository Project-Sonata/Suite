package com.odeyalo.sonata.common.authentication.exception;

import com.odeyalo.sonata.common.shared.ErrorDetails;

public class EmailAlreadyTakenRegistrationFailedException extends RegistrationFailedException {

    public EmailAlreadyTakenRegistrationFailedException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public EmailAlreadyTakenRegistrationFailedException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public EmailAlreadyTakenRegistrationFailedException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

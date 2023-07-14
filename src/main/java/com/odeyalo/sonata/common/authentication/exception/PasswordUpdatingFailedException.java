package com.odeyalo.sonata.common.authentication.exception;

import com.odeyalo.sonata.common.shared.ErrorDetails;
import com.odeyalo.sonata.common.shared.GenericApiException;

public class PasswordUpdatingFailedException extends GenericApiException {
    public PasswordUpdatingFailedException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public PasswordUpdatingFailedException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public PasswordUpdatingFailedException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

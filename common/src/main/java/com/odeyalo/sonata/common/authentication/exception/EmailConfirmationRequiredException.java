package com.odeyalo.sonata.common.authentication.exception;

import com.odeyalo.sonata.common.shared.ErrorDetails;
import com.odeyalo.sonata.common.shared.GenericApiException;

public class EmailConfirmationRequiredException extends GenericApiException {
    public EmailConfirmationRequiredException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public EmailConfirmationRequiredException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public EmailConfirmationRequiredException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

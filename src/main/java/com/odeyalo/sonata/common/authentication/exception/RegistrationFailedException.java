package com.odeyalo.sonata.sonata.common.authentication.exception;

import com.odeyalo.sonata.sonata.common.shared.ErrorDetails;
import com.odeyalo.sonata.sonata.common.shared.GenericApiException;

/**
 * Indicates that registration has been failed and cannot be performed
 */
public class RegistrationFailedException extends GenericApiException {

    public RegistrationFailedException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public RegistrationFailedException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public RegistrationFailedException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

package com.odeyalo.sonata.common.authentication.exception;

import com.odeyalo.sonata.common.shared.ErrorDetails;
import com.odeyalo.sonata.common.shared.GenericApiException;

public class ConfirmationCodeException extends GenericApiException {

    public ConfirmationCodeException(ErrorDetails errorDetails) {
        super(errorDetails);
    }

    public ConfirmationCodeException(String message, ErrorDetails errorDetails) {
        super(message, errorDetails);
    }

    public ConfirmationCodeException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, errorDetails, cause);
    }
}

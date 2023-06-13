package com.odeyalo.sonata.sonata.common.shared;

import lombok.Getter;

@Getter
public class GenericApiException extends RuntimeException {
    protected final ErrorDetails errorDetails;

    public GenericApiException(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }

    public GenericApiException(String message, ErrorDetails errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
    }

    public GenericApiException(String message, ErrorDetails errorDetails, Throwable cause) {
        super(message, cause);
        this.errorDetails = errorDetails;
    }
}

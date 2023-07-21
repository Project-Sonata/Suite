package com.odeyalo.suite.security.exception;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class InvalidAccessTokenException extends AuthenticationException {
    private final String tokenValue;

    /**
     * Construct the exception from message and token value
     * @param message - message to show
     * @param tokenValue - value of the invalid token
     */
    public InvalidAccessTokenException(String message, String tokenValue) {
        super(message);
        this.tokenValue = tokenValue;
    }
}

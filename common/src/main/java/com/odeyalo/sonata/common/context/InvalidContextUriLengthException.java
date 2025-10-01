package com.odeyalo.sonata.common.context;

import java.util.Arrays;

/**
 * Thrown when a received context uri has invalid number of elements
 */
public final class InvalidContextUriLengthException extends MalformedContextUriException {
    private static final String  DEFAULT_MESSAGE_FORMAT = "URI must be 3 elements long!\nParts of the URI: %s";

    public InvalidContextUriLengthException(final String uriString) {
        super(String.format(DEFAULT_MESSAGE_FORMAT, uriString), uriString);
    }

    public InvalidContextUriLengthException(final String[] uriParts) {
        super(String.format(DEFAULT_MESSAGE_FORMAT, Arrays.toString(uriParts)), Arrays.toString(uriParts));
    }

    public InvalidContextUriLengthException(final String message, final String uriString) {
        super(message, uriString);
    }

    public InvalidContextUriLengthException(final String message, final Throwable cause, final String uriString) {
        super(message, cause, uriString);
    }

    public InvalidContextUriLengthException(final Throwable cause, final String uriString) {
        super(cause, uriString);
    }

    public InvalidContextUriLengthException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace, final String uriString) {
        super(message, cause, enableSuppression, writableStackTrace, uriString);
    }
}

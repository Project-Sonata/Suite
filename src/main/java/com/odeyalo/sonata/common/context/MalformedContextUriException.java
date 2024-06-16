package com.odeyalo.sonata.common.context;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MalformedContextUriException extends RuntimeException {
    String uriString;

    public MalformedContextUriException(String uriString) {
        this.uriString = uriString;
    }

    public MalformedContextUriException(String message, String uriString) {
        super(message);
        this.uriString = uriString;
    }

    public MalformedContextUriException(String message, Throwable cause, String uriString) {
        super(message, cause);
        this.uriString = uriString;
    }

    public MalformedContextUriException(Throwable cause, String uriString) {
        super(cause);
        this.uriString = uriString;
    }

    public MalformedContextUriException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String uriString) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.uriString = uriString;
    }
}

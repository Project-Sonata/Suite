package com.odeyalo.sonata.common.user.exception;

public final class UserRegistryException extends RuntimeException {
    public static UserRegistryException defaultException() {
        return new UserRegistryException();
    }

    public static UserRegistryException withCustomMessage(String message) {
        return new UserRegistryException(message);
    }

    public static UserRegistryException withMessageAndCause(String message, Throwable cause) {
        return new UserRegistryException(message, cause);
    }

    public UserRegistryException() {
        super();
    }

    public UserRegistryException(String message) {
        super(message);
    }

    public UserRegistryException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRegistryException(Throwable cause) {
        super(cause);
    }
}

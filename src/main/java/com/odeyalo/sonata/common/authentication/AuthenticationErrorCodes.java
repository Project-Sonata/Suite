package com.odeyalo.sonata.common.authentication;

/**
 * The class contain the list of error codes that can be occurred while working with AuthenticationClient
 */
public class AuthenticationErrorCodes {
    public static final String EMAIL_CONFIRMATION_REQUIRED = "email_confirmation_required";
    public static final String INVALID_CREDENTIALS = "invalid_credentials";
    public static final String INVALID_EMAIL = "invalid_email";
    public static final String EMAIL_ALREADY_TAKEN = "email_already_taken";
    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String INVALID_OLD_PASSWORD = "invalid_old_password";
    public static final String INVALID_NEW_PASSWORD = "new_password_pattern_mismatch";
    public static final String SERVER_ERROR = "server_error";
}
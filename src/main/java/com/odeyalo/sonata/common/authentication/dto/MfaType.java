package com.odeyalo.sonata.sonata.common.authentication.dto;

public enum MfaType {
    /**
     * If MFA should be not enabled.
     */
    NONE,
    /**
     * MFA using TOTP(time-based one time password) using Google Authenticator or other application
     */
    TOTP,
    /**
     * MFA using email message
     */
    EMAIL;
}
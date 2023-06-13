package com.odeyalo.sonata.common.authentication.dto;

import lombok.Getter;

@Getter
public enum AuthenticationProcessType {
    PENDING_MFA("pending_mfa"),
    LOGIN_COMPLETED("login_completed"),
    // If authentication cannot be performed
    FAILED("failed");

    private final String name;

    AuthenticationProcessType(String name) {
        this.name = name;
    }
}
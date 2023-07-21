package com.odeyalo.suite.security.auth.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(staticName = "of")
public class AccessTokenMetadata {
    String userId;
    String[] scopes;
    long issuedAt;
    long expiresIn;
}
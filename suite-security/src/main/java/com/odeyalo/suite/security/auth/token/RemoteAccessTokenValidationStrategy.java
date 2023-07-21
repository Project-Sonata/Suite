package com.odeyalo.suite.security.auth.token;

import reactor.core.publisher.Mono;

/**
 * Strategy to validate the token in remote service
 */
public interface RemoteAccessTokenValidationStrategy {

    Mono<ValidatedAccessToken> validateAccessToken(String tokenValue);

}

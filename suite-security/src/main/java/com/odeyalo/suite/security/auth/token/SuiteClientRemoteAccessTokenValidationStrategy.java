package com.odeyalo.suite.security.auth.token;

import com.odeyalo.sonata.common.authorization.TokenIntrospectionRequest;
import com.odeyalo.sonata.common.authorization.TokenIntrospectionResponse;
import com.odeyalo.sonata.suite.reactive.client.ReactiveTokenIntrospectionClient;
import com.odeyalo.suite.security.auth.token.converter.ValidatedAccessTokenConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

/**
 * Uses the {@link ReactiveTokenIntrospectionClient} to introspect the token
 */
public class SuiteClientRemoteAccessTokenValidationStrategy implements RemoteAccessTokenValidationStrategy {
    private final ReactiveTokenIntrospectionClient tokenIntrospectionClient;
    private final ValidatedAccessTokenConverter<TokenIntrospectionResponse> accessTokenConverter;
    private final Logger logger = LoggerFactory.getLogger(SuiteClientRemoteAccessTokenValidationStrategy.class);

    public SuiteClientRemoteAccessTokenValidationStrategy(ReactiveTokenIntrospectionClient tokenIntrospectionClient, ValidatedAccessTokenConverter<TokenIntrospectionResponse> accessTokenConverter) {
        this.tokenIntrospectionClient = tokenIntrospectionClient;
        this.accessTokenConverter = accessTokenConverter;
        this.logger.info("Using: {} to send request to validate access token", tokenIntrospectionClient);
    }

    @Override
    public Mono<ValidatedAccessToken> validateAccessToken(String tokenValue) {
        return tokenIntrospectionClient.introspectToken(TokenIntrospectionRequest.of(tokenValue))
                .flatMap(r -> r.getBody() != null ? r.getBody() : Mono.empty())
                .map(accessTokenConverter::convertTo);
    }
}

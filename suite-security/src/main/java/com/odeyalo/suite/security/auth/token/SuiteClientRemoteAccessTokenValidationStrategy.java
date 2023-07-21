package com.odeyalo.suite.security.auth.token;

import com.odeyalo.sonata.common.authorization.TokenIntrospectionRequest;
import com.odeyalo.sonata.common.authorization.TokenIntrospectionResponse;
import com.odeyalo.sonata.suite.reactive.client.ReactiveTokenIntrospectionClient;
import com.odeyalo.suite.security.auth.token.converter.ValidatedAccessTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

/**
 * Uses the {@link ReactiveTokenIntrospectionClient} to introspect the token
 */
public class SuiteClientRemoteAccessTokenValidationStrategy implements RemoteAccessTokenValidationStrategy {
    private final ReactiveTokenIntrospectionClient tokenIntrospectionClient;
    private final ValidatedAccessTokenConverter<TokenIntrospectionResponse> accessTokenConverter;

    public SuiteClientRemoteAccessTokenValidationStrategy(ReactiveTokenIntrospectionClient tokenIntrospectionClient, ValidatedAccessTokenConverter<TokenIntrospectionResponse> accessTokenConverter) {
        this.tokenIntrospectionClient = tokenIntrospectionClient;
        System.out.println("CLIENT: "  + tokenIntrospectionClient);
        this.accessTokenConverter = accessTokenConverter;
    }

    @Override
    public Mono<ValidatedAccessToken> validateAccessToken(String tokenValue) {
        return tokenIntrospectionClient.introspectToken(TokenIntrospectionRequest.of(tokenValue))
                .flatMap(r -> r.getBody() != null ? r.getBody() : Mono.empty())
                .map(accessTokenConverter::convertTo);
    }
}

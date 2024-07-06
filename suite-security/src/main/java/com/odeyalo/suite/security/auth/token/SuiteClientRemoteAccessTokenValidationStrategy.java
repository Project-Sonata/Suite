package com.odeyalo.suite.security.auth.token;

import com.odeyalo.sonata.common.authorization.TokenIntrospectionRequest;
import com.odeyalo.sonata.common.authorization.TokenIntrospectionResponse;
import com.odeyalo.sonata.suite.reactive.client.ReactiveTokenIntrospectionClient;
import com.odeyalo.suite.security.auth.token.converter.ValidatedAccessTokenConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    }

    @Override
    public Mono<ValidatedAccessToken> validateAccessToken(String tokenValue) {
        return tokenIntrospectionClient.introspectToken(TokenIntrospectionRequest.of(tokenValue))
                .log("suite-strategy")
                .doOnNext(resp ->
                        logger.info("""
                                [OK] Response from remote token validation service:
                                API status [UP],
                                Protocol: [HTTP],
                                API response status code: [{}]
                                Token has been validated. Token validation result: [{}]""", resp.getStatusCode(), resp.getBody()))
                .flatMap(r -> {
                    Mono<TokenIntrospectionResponse> body = r.getBody();
                    if ( body == null ) {
                        return Mono.error(new IllegalStateException("Api returned a NULL body as the result"));
                    }
                    return body;
                })
                .map(accessTokenConverter::convertTo);
    }
}

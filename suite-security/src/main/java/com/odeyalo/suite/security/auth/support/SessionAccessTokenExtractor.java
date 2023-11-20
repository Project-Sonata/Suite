package com.odeyalo.suite.security.auth.support;

import org.springframework.http.HttpCookie;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class SessionAccessTokenExtractor implements AccessTokenExtractor {
    public static final String TOKEN_COOKIE_NAME = "Access-Token";

    @Override
    public Mono<String> extractToken(ServerWebExchange exchange) {
        HttpCookie accessTokenCookie = exchange.getRequest().getCookies().getFirst(TOKEN_COOKIE_NAME);
        if ( accessTokenCookie != null ) {
            return Mono.just(accessTokenCookie.getValue());
        }
        return Mono.empty();
    }
}

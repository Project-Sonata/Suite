package com.odeyalo.suite.security.auth.support;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Resolve the access token from query param(useful for websocket connections)
 */
@Log4j2
public class QueryParamAccessTokenExtractor implements AccessTokenExtractor {
    private final String TOKEN = "token";
    private String queryParamName = TOKEN;

    @Override
    public Mono<String> extractToken(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getQueryParams().getFirst(queryParamName));
    }

    public String getQueryParamName() {
        return queryParamName;
    }

    public void setQueryParamName(String queryParamName) {
        this.queryParamName = queryParamName;
    }
}
